package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;

import com.pi.PoslovnaBanka.entity.RacunPravnogLica;

public class RacunPravnogLicaTransferDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private BankaTransferDTO bankaDTO;
	
	public RacunPravnogLicaTransferDTO() {
		super();
	}

	public RacunPravnogLicaTransferDTO(int id, BankaTransferDTO bankaDTO) {
		super();
		this.id = id;
		this.bankaDTO = bankaDTO;
	}
	
	public RacunPravnogLicaTransferDTO(RacunPravnogLica racun) {
		this(racun.getId(), new BankaTransferDTO(racun.getBanka()));
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public BankaTransferDTO getBankaDTO() {
		return bankaDTO;
	}
	
	public void setBankaDTO(BankaTransferDTO bankaDTO) {
		this.bankaDTO = bankaDTO;
	}
}
