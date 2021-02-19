package com.pi.PoslovnaBanka.service;

import java.util.List;
import com.pi.PoslovnaBanka.entity.Ukidanje;

public interface UkidanjeServiceInterface {

	Ukidanje findOne(int id);
	List<Ukidanje> findAll();
	int save(String racunPravnogLicaDTO, int id) throws Exception;
	boolean remove(int id);
}
