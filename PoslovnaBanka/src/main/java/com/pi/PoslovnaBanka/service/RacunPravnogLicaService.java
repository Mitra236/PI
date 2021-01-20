package com.pi.PoslovnaBanka.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna();
		
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
		racun.setBrojRacuna(racunPravnogLica.getBrojRacuna());
		racun.setDatumOtvaranja((java.sql.Date) new Date());

		return racunPravnogLicaRepo.save(racun).getId();
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
