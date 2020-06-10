package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.Valuta;
import com.pi.PoslovnaBanka.repository.ValutaRepository;

@Service
public class ValutaService implements ValutaServiceInterface {
	
	@Autowired
	ValutaRepository valutaRepo;

	@Override
	public Valuta findOne(int id) {
		return valutaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Valuta> findAll() {
		return valutaRepo.findAll();
	}

	@Override
	public int save(Valuta valuta) {
		return valutaRepo.save(valuta).getId();
	}

	@Override
	public boolean remove(int id) {
		valutaRepo.deleteById(id);
		return true;
	}

	
}
