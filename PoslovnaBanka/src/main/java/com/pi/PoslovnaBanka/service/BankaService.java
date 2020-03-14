package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.repository.BankaRepository;

public class BankaService implements BankaServiceInterface{
	
	@Autowired
	BankaRepository bankaRepository;

	@Override
	public Banka findOne(int id) {
		return bankaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Banka> findAll() {
		return bankaRepository.findAll();
	}

	@Override
	public int save(Banka banka) {
		return bankaRepository.save(banka).getId();
	}

	@Override
	public boolean remove(int id) {
		bankaRepository.deleteById(id);
		return true;
	}
	
	
}
