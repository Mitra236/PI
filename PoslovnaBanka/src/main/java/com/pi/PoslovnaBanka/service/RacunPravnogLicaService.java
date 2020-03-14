package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.repository.RacunPravnogLicaRepository;

public class RacunPravnogLicaService implements RacunPravnogLicaServiceInterface {
	
	@Autowired
	RacunPravnogLicaRepository racunPravnogLicaRepo;

	@Override
	public RacunPravnogLica findOne(int id) {
		return racunPravnogLicaRepo.findById(id).orElse(null);
	}

	@Override
	public List<RacunPravnogLica> findAll() {
		return racunPravnogLicaRepo.findAll();
	}

	@Override
	public int save(RacunPravnogLica racunPravnogLica) {
		return racunPravnogLicaRepo.save(racunPravnogLica).getId();
	}

	@Override
	public boolean remove(int id) {
		racunPravnogLicaRepo.deleteById(id);
		return true;
	}

}
