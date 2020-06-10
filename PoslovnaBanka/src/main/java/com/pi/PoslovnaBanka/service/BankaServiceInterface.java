package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.entity.Banka;

public interface BankaServiceInterface {

	Banka findOne(int id);
	List<Banka> findAll();
	int save(Banka banka);
	boolean remove(int id);
	Banka getBankByName(String naziv);
}
