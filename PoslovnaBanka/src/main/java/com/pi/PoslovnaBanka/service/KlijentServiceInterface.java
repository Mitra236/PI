package com.pi.PoslovnaBanka.service;

import org.springframework.data.domain.Page;

import com.pi.PoslovnaBanka.entity.Klijent;

public interface KlijentServiceInterface {

	Klijent findOne(int id);
	Page<Klijent> findAll(int page, int size);
	int save(Klijent banka);
	boolean remove(int id);

}
