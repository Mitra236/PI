package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;

import com.pi.PoslovnaBanka.entity.PorukeUPaketu;

public class PorukeUPaketuDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private PorukaDTO poruka;
	
	public PorukeUPaketuDTO(int id, PorukaDTO poruka) {
		super();
		this.id = id;
		this.poruka = poruka;
	}

	public PorukeUPaketuDTO() {
		super();
	}

	public PorukeUPaketuDTO(PorukeUPaketu porukePaket) {
		this(porukePaket.getId(), new PorukaDTO(porukePaket.getPoruka()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PorukaDTO getPoruka() {
		return poruka;
	}

	public void setPoruka(PorukaDTO poruka) {
		this.poruka = poruka;
	}
}
