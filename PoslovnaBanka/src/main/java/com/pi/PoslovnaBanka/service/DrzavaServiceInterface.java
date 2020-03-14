package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.entity.Drzava;

public interface DrzavaServiceInterface {

	Drzava findOne(int id);
	List<Drzava> findAll();
	int save(Drzava drzava);
	boolean remove(int id);
}
