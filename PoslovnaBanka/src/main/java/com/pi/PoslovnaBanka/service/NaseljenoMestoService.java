package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pi.PoslovnaBanka.entity.NaseljenoMesto;
import com.pi.PoslovnaBanka.repository.NaseljenoMestoRepository;

public class NaseljenoMestoService implements NaseljenoMestoServiceInterface {
	
	@Autowired
	NaseljenoMestoRepository naseljenoMestoRepo;

	@Override
	public NaseljenoMesto findOne(int id) {
		return naseljenoMestoRepo.findById(id).orElse(null);
	}

	@Override
	public List<NaseljenoMesto> findAll() {
		return naseljenoMestoRepo.findAll();
	}

	@Override
	public int save(NaseljenoMesto naseljenoMesto) {
		return naseljenoMestoRepo.save(naseljenoMesto).getId();
	}

	@Override
	public boolean remove(int id) {
		naseljenoMestoRepo.deleteById(id);
		return true;
	}

}
