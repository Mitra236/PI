package com.pi.PoslovnaBanka.service;

import org.springframework.data.domain.Page;

import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;

public interface RacunPravnogLicaServiceInterface {

	RacunPravnogLicaDTO findOne(int id);
	Page<RacunPravnogLicaDTO> findAll(int page, int size);
	int save(RacunPravnogLicaDTO racunPravnogLica) throws Exception;
	boolean remove(int id);
	RacunPravnogLicaDTO getAccountByUser(int client);
	RacunPravnogLicaDTO getAccountByUserAndAccountNumber(int id, String number);
	String generateAccountNumber(String sifraBanke) throws Exception;
}
