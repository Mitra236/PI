package com.pi.PoslovnaBanka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.dto.PorukaDTO;
import com.pi.PoslovnaBanka.dto.PorukaTransferDTO;
import com.pi.PoslovnaBanka.entity.Poruka;
import com.pi.PoslovnaBanka.repository.MedjubankarskiTransferRepository;

@Service
public class MedjubankarskiTransferService implements MedjubankarskiTransferServiceInterface {
	
	@Autowired
	MedjubankarskiTransferRepository medjubankarskiTransferRepo;

	@Override
	public List<PorukaTransferDTO> findByTransaction(int id) {
		List<PorukaTransferDTO> messagesToDTO = new ArrayList<PorukaTransferDTO>();
		for (Poruka poruka: medjubankarskiTransferRepo.findByTransaction(id)) {
			messagesToDTO.add(new PorukaTransferDTO(poruka));
		}
		return messagesToDTO;
	}

	@Override
	public List<PorukaDTO> findAll() {
		List<PorukaDTO> messagesToDTO = new ArrayList<PorukaDTO>();
		for (Poruka poruka: medjubankarskiTransferRepo.findAll()) {
			messagesToDTO.add(new PorukaDTO(poruka));
		}
		return messagesToDTO;
	}

	@Override
	public int save(Poruka medjubankarskiTransfer) {
		return medjubankarskiTransferRepo.save(medjubankarskiTransfer).getId();
	}

	@Override
	public boolean remove(int id) {
		medjubankarskiTransferRepo.deleteById(id);
		return true;
	}
	 
	
}
