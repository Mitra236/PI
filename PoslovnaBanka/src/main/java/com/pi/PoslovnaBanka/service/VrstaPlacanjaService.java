package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pi.PoslovnaBanka.entity.VrstaPlacanja;
import com.pi.PoslovnaBanka.repository.VrstaPlacanjaRepository;

public class VrstaPlacanjaService implements VrstaPlacanjaServiceInterface {
	
	@Autowired
	VrstaPlacanjaRepository vrstaPlacanjaRepo;

	@Override
	public VrstaPlacanja findOne(int id) {
		return vrstaPlacanjaRepo.findById(id).orElse(null);
	}

	@Override
	public List<VrstaPlacanja> findAll() {
		return vrstaPlacanjaRepo.findAll();
	}

	@Override
	public int save(VrstaPlacanja vrstaPlacanja) {
		return vrstaPlacanjaRepo.save(vrstaPlacanja).getId();
	}

	@Override
	public boolean remove(int id) {
		vrstaPlacanjaRepo.deleteById(id);
		return true;
	}

}
