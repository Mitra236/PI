package com.pi.PoslovnaBanka.service;

import java.util.List;
import com.pi.PoslovnaBanka.entity.NaseljenoMesto;

public interface NaseljenoMestoServiceInterface {

	NaseljenoMesto findOne(int id);
	List<NaseljenoMesto> findAll();
	int save(NaseljenoMesto naseljenoMesto);
	boolean remove(int id);
}
