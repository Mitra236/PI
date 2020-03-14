package com.pi.PoslovnaBanka.service;

import java.util.List;
import com.pi.PoslovnaBanka.entity.MedjubankarskiTransfer;

public interface MedjubankarskiTransferServiceInterface {
	
	MedjubankarskiTransfer findOne(int id);
	List<MedjubankarskiTransfer> findAll();
	int save(MedjubankarskiTransfer medjubankarskiTransfer);
	boolean remove(int id);
}
