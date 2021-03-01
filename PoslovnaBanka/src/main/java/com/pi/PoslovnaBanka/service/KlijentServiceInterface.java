package com.pi.PoslovnaBanka.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pi.PoslovnaBanka.dto.KlijentDTO;
import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.entity.Klijent;

public interface KlijentServiceInterface {

	KlijentDTO findOne(int id);
	List<Klijent> findAllVazece();
	List<Klijent> findAll();
	Page<KlijentDTO> findAll(int page, int size);
	int save(KlijentDTO banka);
	void remove(KlijentDTO klijent);
	KlijentDTO getUserByAccountNumber(String racunPoverioca);
	KlijentDTO login(KlijentDTO klijentDTO);
}
