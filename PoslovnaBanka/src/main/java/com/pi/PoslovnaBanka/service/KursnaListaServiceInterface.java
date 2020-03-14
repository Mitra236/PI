package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.entity.KursnaLista;

public interface KursnaListaServiceInterface {
	
	KursnaLista findOne(int id);
	List<KursnaLista> findAll();
	int save(KursnaLista kursnaLista);
	boolean remove(int id);
	
}
