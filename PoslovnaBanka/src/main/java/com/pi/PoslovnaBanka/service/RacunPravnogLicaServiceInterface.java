package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;

public interface RacunPravnogLicaServiceInterface {

	RacunPravnogLicaDTO findOne(int id);
	List<RacunPravnogLicaDTO> findAll();
	int save(RacunPravnogLicaDTO racunPravnogLica);
	boolean remove(int id);
	RacunPravnogLicaDTO getAccountByUser(int client);
}
