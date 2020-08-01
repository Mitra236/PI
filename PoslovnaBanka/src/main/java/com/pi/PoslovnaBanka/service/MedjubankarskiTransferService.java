package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.Poruka;
import com.pi.PoslovnaBanka.repository.MedjubankarskiTransferRepository;

@Service
public class MedjubankarskiTransferService implements MedjubankarskiTransferServiceInterface {
	
	@Autowired
	MedjubankarskiTransferRepository medjubankarskiTransferRepo;

	@Override
	public Poruka findOne(int id) {
		return medjubankarskiTransferRepo.findById(id).orElse(null);
	}

	@Override
	public List<Poruka> findAll() {
		return medjubankarskiTransferRepo.findAll();
	}

	@Override
	public int save(Poruka medjubankarskiTransfer) {
		return medjubankarskiTransferRepo.save(medjubankarskiTransfer).getId();
	}

	@Override
	public boolean remove(int id) {
		medjubankarskiTransferRepo.deleteById(id);
		return true;
	}
	 
	
}
