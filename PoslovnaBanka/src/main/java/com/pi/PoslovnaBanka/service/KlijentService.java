package com.pi.PoslovnaBanka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.repository.KlijentRepository;

@Service
public class KlijentService implements KlijentServiceInterface {
	
	@Autowired
	KlijentRepository klijentRepo;

	@Override
	public Klijent findOne(int id) {
		return klijentRepo.findById(id).orElse(null);
	}

	@Override
	public Page<Klijent> findAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return klijentRepo.findAll(pageable);
	}

	@Override
	public int save(Klijent banka) {
		return klijentRepo.save(banka).getId();
	}

	@Override
	public boolean remove(int id) {
		klijentRepo.deleteById(id);
		return true;
	}

}
