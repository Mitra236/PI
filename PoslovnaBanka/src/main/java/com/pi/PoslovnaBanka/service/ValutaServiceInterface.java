package com.pi.PoslovnaBanka.service;

import java.util.List;

import com.pi.PoslovnaBanka.dto.ValutaDTO;
import com.pi.PoslovnaBanka.entity.Valuta;

public interface ValutaServiceInterface {
	
	Valuta findOne(int id);
	List<ValutaDTO> findAll();
	int save(Valuta valuta);
	boolean remove(int id);
}
