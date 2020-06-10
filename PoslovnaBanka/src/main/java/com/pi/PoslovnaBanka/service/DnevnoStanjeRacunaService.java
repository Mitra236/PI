package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;
import com.pi.PoslovnaBanka.repository.DnevnoStanjeRacunaRepository;

@Service
public class DnevnoStanjeRacunaService implements DnevnoStanjeRacunaServiceInterface{
	
	@Autowired
	DnevnoStanjeRacunaRepository dnevnoStanjeRepo;

	@Override
	public DnevnoStanjeRacuna findOne(int id) {
		return dnevnoStanjeRepo.findById(id).orElse(null);
	}

	@Override
	public List<DnevnoStanjeRacuna> findAll() {
		return dnevnoStanjeRepo.findAll();
	}

	@Override
	public int save(DnevnoStanjeRacuna dnevnoStanje) {
		return dnevnoStanjeRepo.save(dnevnoStanje).getBrojIzvoda();
	}

	@Override
	public boolean remove(int id) {
		dnevnoStanjeRepo.deleteById(id);
		return true;
	}

}
