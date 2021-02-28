package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.dto.PorukaDTO;
import com.pi.PoslovnaBanka.dto.PorukaTransferDTO;
import com.pi.PoslovnaBanka.entity.Poruka;

public interface MedjubankarskiTransferServiceInterface {
	
	List<PorukaTransferDTO> findByTransaction(int id);
	List<PorukaDTO> findAll();
	int save(Poruka medjubankarskiTransfer);
	boolean remove(int id);
}
