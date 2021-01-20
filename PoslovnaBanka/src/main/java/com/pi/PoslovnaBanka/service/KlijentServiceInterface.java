package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pi.PoslovnaBanka.dto.KlijentDTO;

public interface KlijentServiceInterface {

	KlijentDTO findOne(int id);
	List<KlijentDTO> findAll();
	Page<KlijentDTO> findAll(int page, int size);
	int save(KlijentDTO banka);
	boolean remove(int id);
	KlijentDTO getUserByAccountNumber(String racunPoverioca);
	KlijentDTO login(KlijentDTO klijentDTO);
}
