package com.pi.PoslovnaBanka.service;

import java.util.List;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;

public interface RacunPravnogLicaServiceInterface {

	RacunPravnogLica findOne(int id);
	List<RacunPravnogLica> findAll();
	int save(RacunPravnogLica racunPravnogLica);
	boolean remove(int id);
}
