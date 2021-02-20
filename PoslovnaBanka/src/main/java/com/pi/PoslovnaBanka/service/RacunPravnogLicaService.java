package com.pi.PoslovnaBanka.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<RacunPravnogLicaDTO> findAll() {
		List<RacunPravnogLicaDTO> racunPravnogLica = new ArrayList<RacunPravnogLicaDTO>();
		for(RacunPravnogLica r: racunPravnogLicaRepo.findAll()) {
			racunPravnogLica.add(new RacunPravnogLicaDTO(r));
		}
		return racunPravnogLica;
	}

	@Override
	@Transactional
	public int save(RacunPravnogLicaDTO racunPravnogLica) {
		RacunPravnogLica racun = new RacunPravnogLica();
		Klijent klijent = new Klijent();
		
		Valuta valuta = valutaRepo.findById(racunPravnogLica.getValuta().getId()).orElse(null);
		Banka banka = bankaRepo.findById(racunPravnogLica.getBanka().getId()).orElse(null);
		
		klijent.setAdresa(racunPravnogLica.getKlijent().getAdresa());
		klijent.setIme(racunPravnogLica.getKlijent().getIme());
		klijent.setPrezime(racunPravnogLica.getKlijent().getPrezime());
		klijent.setJMBG(racunPravnogLica.getKlijent().getJMBG());
		klijent.setEmail(racunPravnogLica.getKlijent().getEmail());
		klijent.setUloga(racunPravnogLica.getKlijent().getUloga());
		klijentRepo.save(klijent);
		
		
		racun.setBanka(banka);
		racun.setValuta(valuta);
		racun.setKlijent(klijent);
		String accountNumber = generateAccountNumber();
		racun.setBrojRacuna(banka.getSifraBanke().concat("-" + accountNumber + "-" + generateControlNumber(banka.getSifraBanke(), accountNumber)));
		racun.setDatumOtvaranja(java.sql.Date.valueOf(LocalDate.now()));
		
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
	
	private static String generateAccountNumber() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		sb.append(random.nextInt(10) + 1);
		
		for (int i = 0; i < 12; i++) {
	        sb.append(random.nextInt(11));
	    }

	    return sb.toString();
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
