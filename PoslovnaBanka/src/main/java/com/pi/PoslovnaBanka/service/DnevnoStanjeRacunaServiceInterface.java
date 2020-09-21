package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.dto.DnevnoStanjeDTO;

public interface DnevnoStanjeRacunaServiceInterface {

	DnevnoStanjeDTO findOne(int id);
	List<DnevnoStanjeDTO> findAll();
	int save(DnevnoStanjeDTO dnevnoStanje);
	boolean remove(int id);
	DnevnoStanjeDTO getStateByUser(int id);
}
