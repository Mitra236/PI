package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;

import com.pi.PoslovnaBanka.entity.PorukeUPaketu;

public class PaketDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
	private int porukaId;
	private TransakcijaTransferDTO transakcija;
	
	public PaketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public PaketDTO(int id, int porukaId, TransakcijaTransferDTO transakcija) {
		super();
		this.id = id;
		this.porukaId = porukaId;
		this.transakcija = transakcija;
	}

	public PaketDTO(PorukeUPaketu porukePaket) {
		this(porukePaket.getId(), porukePaket.getPoruka().getId(), new TransakcijaTransferDTO(porukePaket.getTransakcija()));
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPorukaId() {
		return porukaId;
	}
	
	public void setPorukaId(int porukaId) {
		this.porukaId = porukaId;
	}

	public TransakcijaTransferDTO getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(TransakcijaTransferDTO transakcija) {
		this.transakcija = transakcija;
	}
}
