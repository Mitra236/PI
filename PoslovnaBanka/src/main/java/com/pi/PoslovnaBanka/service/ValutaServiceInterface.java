package com.pi.PoslovnaBanka.service;

import java.util.List;
import com.pi.PoslovnaBanka.entity.Valuta;

public interface ValutaServiceInterface {
	
	Valuta findOne(int id);
	List<Valuta> findAll();
	int save(Valuta valuta);
	boolean remove(int id);
}
