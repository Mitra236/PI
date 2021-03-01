package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.entity.Banka;

public interface BankaServiceInterface {

	Banka findOne(int id);
	List<Banka> findAll();
	Banka save(Banka banka);
	void remove(Banka banka);
	Banka getBankByName(String naziv);
}
