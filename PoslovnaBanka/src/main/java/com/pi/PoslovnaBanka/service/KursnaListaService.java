package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pi.PoslovnaBanka.entity.KursnaLista;
import com.pi.PoslovnaBanka.repository.KursnaListaRepository;

public class KursnaListaService implements KursnaListaServiceInterface {
	
	@Autowired
	KursnaListaRepository kursnaListaRepo;
	

	@Override
	public KursnaLista findOne(int id) {
		return kursnaListaRepo.findById(id).orElse(null);
	}

	@Override
	public List<KursnaLista> findAll() {
		return kursnaListaRepo.findAll();
	}

	@Override
	public int save(KursnaLista kursnaLista) {
		return kursnaListaRepo.save(kursnaLista).getId();
	}

	@Override
	public boolean remove(int id) {
		kursnaListaRepo.deleteById(id);
		return true;
	}
	
	
}
