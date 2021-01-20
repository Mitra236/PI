package com.pi.PoslovnaBanka.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;
import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.entity.Ukidanje;
import com.pi.PoslovnaBanka.repository.DnevnoStanjeRacunaRepository;
import com.pi.PoslovnaBanka.repository.KlijentRepository;
import com.pi.PoslovnaBanka.repository.RacunPravnogLicaRepository;
import com.pi.PoslovnaBanka.repository.UkidanjeRepository;

@Service
@Transactional
public class UkidanjeService implements UkidanjeServiceInterface {
	
	@Autowired
	UkidanjeRepository ukidanjeRepo;
	
	@Autowired
	RacunPravnogLicaRepository racunPravnogLicaRepo;
	
	@Autowired
	KlijentRepository klijentRepo;
	
	@Autowired
	DnevnoStanjeRacunaRepository dnevnoStanje;

	@Override
	public Ukidanje findOne(int id) {
		return ukidanjeRepo.findById(id).orElse(null);
	}

	@Override
	public List<Ukidanje> findAll() {
		return ukidanjeRepo.findAll();
	}

	@Override
	@Transactional
	public int save(String racunPravnogLicaDTO, int id) {
		RacunPravnogLica racunPravnogLica = racunPravnogLicaRepo.findById(id).orElse(null);
		racunPravnogLica.setVazeci(false);
		racunPravnogLicaRepo.save(racunPravnogLica);
		
		Ukidanje ukidanje = new Ukidanje();
		ukidanje.setDatumUkidanja(Date.valueOf(LocalDate.now()));
		ukidanje.setSredstvaSePrenoseNaRacun(racunPravnogLicaDTO);
		
		Klijent pravnoLice = klijentRepo.findById(racunPravnogLica.getKlijent().getId()).orElse(null);
		Klijent poverilac = klijentRepo.getUserByAccountNumber(racunPravnogLicaDTO);
		
		DnevnoStanjeRacuna dnevnoStanjeRacunaPoverioca = dnevnoStanje.getStateByUserId(poverilac.getId());
		DnevnoStanjeRacuna dnevnoStanjeRacunaPravnogLica = dnevnoStanje.getStateByUserId(pravnoLice.getId());

		dnevnoStanjeRacunaPoverioca.setTrenutnoStanje(dnevnoStanjeRacunaPoverioca.getTrenutnoStanje() + dnevnoStanjeRacunaPravnogLica.getTrenutnoStanje());
		dnevnoStanjeRacunaPoverioca.setPrometNaTeret(dnevnoStanjeRacunaPoverioca.getPrometUKorist() + dnevnoStanjeRacunaPravnogLica.getTrenutnoStanje());
		dnevnoStanjeRacunaPoverioca.setDatumPoslednjegPrometa(Date.valueOf(LocalDate.now()));
		dnevnoStanje.save(dnevnoStanjeRacunaPoverioca);
		
		return ukidanjeRepo.save(ukidanje).getId();
	}

	@Override
	public boolean remove(int id) {
		ukidanjeRepo.deleteById(id);
		return true;
	}

}
