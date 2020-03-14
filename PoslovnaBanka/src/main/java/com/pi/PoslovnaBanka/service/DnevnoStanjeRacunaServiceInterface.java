package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;

public interface DnevnoStanjeRacunaServiceInterface {

	DnevnoStanjeRacuna findOne(int id);
	List<DnevnoStanjeRacuna> findAll();
	int save(DnevnoStanjeRacuna dnevnoStanje);
	boolean remove(int id);
}
