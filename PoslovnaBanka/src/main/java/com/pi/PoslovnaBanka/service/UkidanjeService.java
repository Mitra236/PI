package com.pi.PoslovnaBanka.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.entity.Ukidanje;
import com.pi.PoslovnaBanka.repository.RacunPravnogLicaRepository;
import com.pi.PoslovnaBanka.repository.UkidanjeRepository;

@Service
@Transactional
public class UkidanjeService implements UkidanjeServiceInterface {
	
	@Autowired
	UkidanjeRepository ukidanjeRepo;
	
	@Autowired
	RacunPravnogLicaRepository racunPravnogLicaRepo;

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
		
		return ukidanjeRepo.save(ukidanje).getId();
	}

	@Override
	public boolean remove(int id) {
		ukidanjeRepo.deleteById(id);
		return true;
	}

}
