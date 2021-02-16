package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.dto.TransakcijaDTO;
import com.pi.PoslovnaBanka.entity.Transakcija;

public interface TransakcijaServiceInterface {

	TransakcijaDTO findOne(int id);
	List<Transakcija> findAll();
	int save(TransakcijaDTO transakcija) throws Exception ;
	boolean remove(int id);
}
