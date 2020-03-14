package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.entity.Klijent;

public interface KlijentServiceInterface {

	Klijent findOne(int id);
	List<Klijent> findAll();
	int save(Klijent banka);
	boolean remove(int id);
}
