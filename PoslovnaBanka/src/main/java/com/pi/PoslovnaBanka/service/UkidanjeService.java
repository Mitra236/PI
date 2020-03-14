package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pi.PoslovnaBanka.entity.Ukidanje;
import com.pi.PoslovnaBanka.repository.UkidanjeRepository;

public class UkidanjeService implements UkidanjeServiceInterface {
	
	@Autowired
	UkidanjeRepository ukidanjeRepo;

	@Override
	public Ukidanje findOne(int id) {
		return ukidanjeRepo.findById(id).orElse(null);
	}

	@Override
	public List<Ukidanje> findAll() {
		return ukidanjeRepo.findAll();
	}

	@Override
	public int save(Ukidanje ukidanje) {
		return ukidanjeRepo.save(ukidanje).getId();
	}

	@Override
	public boolean remove(int id) {
		ukidanjeRepo.deleteById(id);
		return true;
	}

}
