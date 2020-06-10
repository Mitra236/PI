package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.KursUValuti;
import com.pi.PoslovnaBanka.repository.KursUValutiRepository;

@Service
public class KursUValutiService implements KursUValutiServiceInterface {
	
	@Autowired
	KursUValutiRepository kursValutaRepo;

	@Override
	public KursUValuti findOne(int id) {
		return kursValutaRepo.findById(id).orElse(null);
	}

	@Override
	public List<KursUValuti> findAll() {
		return kursValutaRepo.findAll();
	}

	@Override
	public int save(KursUValuti kursValuta) {
		return kursValutaRepo.save(kursValuta).getRedniBroj();
	}

	@Override
	public boolean remove(int id) {
		kursValutaRepo.deleteById(id);
		return true;
	}

}
