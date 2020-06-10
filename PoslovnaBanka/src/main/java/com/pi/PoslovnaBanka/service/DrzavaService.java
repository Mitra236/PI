package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.Drzava;
import com.pi.PoslovnaBanka.repository.DrzavaRepository;

@Service
public class DrzavaService implements DrzavaServiceInterface {
	
	@Autowired
	DrzavaRepository drzavaRepo;

	@Override
	public Drzava findOne(int id) {
		return drzavaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Drzava> findAll() {
		return drzavaRepo.findAll();
	}

	@Override
	public int save(Drzava drzava) {
		return drzavaRepo.save(drzava).getId();
	}

	@Override
	public boolean remove(int id) {
		drzavaRepo.deleteById(id);
		return true;
	}

}
