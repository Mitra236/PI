package com.pi.PoslovnaBanka.service;

import java.util.List;
import com.pi.PoslovnaBanka.entity.Poruka;

public interface MedjubankarskiTransferServiceInterface {
	
	Poruka findOne(int id);
	List<Poruka> findAll();
	int save(Poruka medjubankarskiTransfer);
	boolean remove(int id);
}
