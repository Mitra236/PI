package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.repository.BankaRepository;

@Service
public class BankaService implements BankaServiceInterface{
	
	@Autowired
	BankaRepository bankaRepository;

	@Override
	public Banka findOne(int id) {
		return bankaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Banka> findAll() {
		return bankaRepository.getVazeceBanke();
	}

	@Override
	public void remove(Banka banka) {
		Banka removedBanka = bankaRepository.findById(banka.getId()).orElse(null);
		removedBanka.setVazeci(false);
		bankaRepository.save(removedBanka);
	}

	@Override
	public Banka getBankByName(String naziv) {
		return bankaRepository.getBankByName(naziv);
	}

	@Override
	public Banka save(Banka banka) {
		return bankaRepository.save(banka);
	}


	
	
}
