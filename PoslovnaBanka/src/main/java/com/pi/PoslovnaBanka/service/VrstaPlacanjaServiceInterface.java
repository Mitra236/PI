package com.pi.PoslovnaBanka.service;

import java.util.List;
import com.pi.PoslovnaBanka.entity.VrstaPlacanja;

public interface VrstaPlacanjaServiceInterface {

	VrstaPlacanja findOne(int id);
	List<VrstaPlacanja> findAll();
	int save(VrstaPlacanja vrstaPlacanja);
	boolean remove(int id);
}
