package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;

import com.pi.PoslovnaBanka.entity.Banka;

public class BankaTransferDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sifraBanke;
	private String swift;
	
	
	public BankaTransferDTO() {
		super();
	}

	
	public BankaTransferDTO(String sifraBanke, String swift) {
		super();
		this.sifraBanke = sifraBanke;
		this.swift = swift;
	}
	
	public BankaTransferDTO(Banka banka) {
		this(banka.getSifraBanke(), banka.getSWIFT());
	}


	public String getSifraBanke() {
		return sifraBanke;
	}
	
	public void setSifraBanke(String sifraBanke) {
		this.sifraBanke = sifraBanke;
	}
	
	public String getSwift() {
		return swift;
	}
	
	public void setSwift(String swift) {
		this.swift = swift;
	}
}
