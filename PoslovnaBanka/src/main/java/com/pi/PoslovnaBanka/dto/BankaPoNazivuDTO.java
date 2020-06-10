package com.pi.PoslovnaBanka.dto;

import com.pi.PoslovnaBanka.entity.Banka;

public class BankaPoNazivuDTO {

	private int id;
	private String naziv;
	
	public BankaPoNazivuDTO(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public BankaPoNazivuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankaPoNazivuDTO(Banka banka) {
		this(banka.getId(), banka.getNaziv());
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
