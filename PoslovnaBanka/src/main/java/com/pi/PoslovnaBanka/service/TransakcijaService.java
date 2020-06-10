package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.Transakcija;
import com.pi.PoslovnaBanka.repository.TransakcijaRepository;

@Service
public class TransakcijaService implements TransakcijaServiceInterface {
	
	@Autowired
	TransakcijaRepository transakcijaRepo;

	@Override
	public Transakcija findOne(int id) {
		return transakcijaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Transakcija> findAll() {
		return transakcijaRepo.findAll();
	}

	@Override
	public int save(Transakcija transakcija) {
		return transakcijaRepo.save(transakcija).getBrojStavke();
	}

	@Override
	public boolean remove(int id) {
		transakcijaRepo.deleteById(id);
		return true;
	}

}
