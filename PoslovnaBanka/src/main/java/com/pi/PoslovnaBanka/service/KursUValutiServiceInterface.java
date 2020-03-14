package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.entity.KursUValuti;

public interface KursUValutiServiceInterface {
	
	KursUValuti findOne(int id);
	List<KursUValuti> findAll();
	int save(KursUValuti kursValuta);
	boolean remove(int id);
}
