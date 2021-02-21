package com.pi.PoslovnaBanka.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pi.PoslovnaBanka.dto.DnevnoStanjeDTO;
import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;
import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;
import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.entity.Valuta;
import com.pi.PoslovnaBanka.repository.BankaRepository;
import com.pi.PoslovnaBanka.repository.DnevnoStanjeRacunaRepository;
import com.pi.PoslovnaBanka.repository.KlijentRepository;
import com.pi.PoslovnaBanka.repository.RacunPravnogLicaRepository;
import com.pi.PoslovnaBanka.repository.ValutaRepository;

@Service
@Transactional
public class RacunPravnogLicaService implements RacunPravnogLicaServiceInterface {
	
	@Autowired
	RacunPravnogLicaRepository racunPravnogLicaRepo;
	
	@Autowired
	KlijentRepository klijentRepo;
	
	@Autowired
	BankaRepository bankaRepo;
	
	@Autowired
	ValutaRepository valutaRepo;
	
	@Autowired
	DnevnoStanjeRacunaRepository dnevnoStanjeRepo;

	@Override
	public RacunPravnogLicaDTO findOne(int id) {
		return new RacunPravnogLicaDTO(racunPravnogLicaRepo.findById(id).orElse(null));
	}

	@Override
	public Page<RacunPravnogLicaDTO> findAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<RacunPravnogLica> entities = racunPravnogLicaRepo.findAll(pageable);
		Page<RacunPravnogLicaDTO> dtoPage = entities.map(new Function<RacunPravnogLica, RacunPravnogLicaDTO>() {
			@Override
			public RacunPravnogLicaDTO apply(RacunPravnogLica racun) {
				RacunPravnogLicaDTO racunDto = new RacunPravnogLicaDTO(racun);
				return racunDto;
			}
		});
		return dtoPage;
	}

	@Override
	@Transactional
	public int save(RacunPravnogLicaDTO racunPravnogLica) throws Exception {
		RacunPravnogLica racun = new RacunPravnogLica();
		Klijent klijent = klijentRepo.findById(racunPravnogLica.getKlijent().getId()).orElse(null);
		
		Valuta valuta = valutaRepo.findById(racunPravnogLica.getValuta().getId()).orElse(null);
		Banka banka = bankaRepo.findById(racunPravnogLica.getBanka().getId()).orElse(null);
				
		racun.setBanka(banka);
		racun.setValuta(valuta);
		racun.setKlijent(klijent);
		if (isAccountNumberUnique(racun.getBrojRacuna())) {
			racun.setBrojRacuna(racun.getBrojRacuna());
		} else {
			throw new Exception("Generisani broj racuna se poklapa sa postojecim, pokusajte kreirati nalog ponovo");
		}
		racun.setDatumOtvaranja(java.sql.Date.valueOf(LocalDate.now()));
		
		klijentRepo.save(klijent);
		racunPravnogLicaRepo.save(racun);
		
		for (DnevnoStanjeDTO dnevnoStanjeDTO : racunPravnogLica.getDnevnoStanjeRacuna()) {
			DnevnoStanjeRacuna newDailyState = createDailyAccountState(dnevnoStanjeDTO);
			newDailyState.setRacunPravnogLica(racun);
			dnevnoStanjeRepo.save(newDailyState);
		}

		return racun.getId();
	}
	
	private static DnevnoStanjeRacuna createDailyAccountState(DnevnoStanjeDTO dnevnoStanje)	{
		DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna();
		
		dnevnoStanjeRacuna.setDatumPoslednjegPrometa(java.sql.Date.valueOf(LocalDate.now()));
		dnevnoStanjeRacuna.setPrethodnoStanje(0);
		dnevnoStanjeRacuna.setTrenutnoStanje(dnevnoStanje.getTrenutnoStanje());
		dnevnoStanjeRacuna.setPrometNaTeret(0);
		dnevnoStanjeRacuna.setPrometUKorist(0);
		
		return dnevnoStanjeRacuna;
	}
	
	public String generateAccountNumber(String sifraBanke) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		sb.append(random.nextInt(10) + 1);
		
		for (int i = 0; i < 12; i++) {
	        sb.append(random.nextInt(11));
	    }

	    return sifraBanke.concat("-" + sb.toString() + "-" + generateControlNumber(sifraBanke, sb.toString()));
	}
	
	private static String generateControlNumber(String bankNum, String accountNumber) {
		double randomNum;		
		try {
			randomNum = Double.parseDouble(bankNum.concat(accountNumber));
		} catch(NumberFormatException e) {
			randomNum = 0;
		}
		double reminder =  randomNum % 97;
		
		DecimalFormat format = new DecimalFormat("0.#");
		return String.valueOf(format.format(reminder));
	}
	
	private boolean isAccountNumberUnique(String accountNumber) {
		return findAll(0, Integer.MAX_VALUE)
					.stream()
					.noneMatch(account -> account.getBrojRacuna().equals(accountNumber));
	}

	@Override
	public boolean remove(int id) {
		racunPravnogLicaRepo.deleteById(id);
		return true;
	}

	@Override
	public RacunPravnogLicaDTO getAccountByUser(int client) {
		return new RacunPravnogLicaDTO(racunPravnogLicaRepo.getAccountByUser(client));
	}

	@Override
	public RacunPravnogLicaDTO getAccountByUserAndAccountNumber(int id, String number) {
		return new RacunPravnogLicaDTO(racunPravnogLicaRepo.getAccountByUserAndAccountNumber(id, number));
	}
}
