package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;

import com.pi.PoslovnaBanka.entity.Poruka;


public class MedjubankarskiTransferDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private double ukupanIznos;
	private String tip;
	private TransakcijaDTO transakcija;
	private BankaDTO racunPoverioca;
	private BankaDTO racunNalogodavca;
	
	public MedjubankarskiTransferDTO(int id, double ukupanIznos, String tip, TransakcijaDTO transakcija,
			BankaDTO racunPoverioca, BankaDTO racunNalogodavca) {
		super();
		this.id = id;
		this.ukupanIznos = ukupanIznos;
		this.tip = tip;
		this.transakcija = transakcija;
		this.racunPoverioca = racunPoverioca;
		this.racunNalogodavca = racunNalogodavca;
	}

	public MedjubankarskiTransferDTO() {
		super();
	}
	
//	public MedjubankarskiTransferDTO(Poruka medjubankarskiTransfer) {
//		this(medjubankarskiTransfer.getId(), medjubankarskiTransfer.getUkupanIznos(), medjubankarskiTransfer.getTip(), 
//				new TransakcijaDTO(medjubankarskiTransfer.getTransakcija()), new BankaDTO(medjubankarskiTransfer.getRacunPoverioca()),
//					new BankaDTO(medjubankarskiTransfer.getRacunNalogodavca()));
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public TransakcijaDTO getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(TransakcijaDTO transakcija) {
		this.transakcija = transakcija;
	}

	public BankaDTO getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(BankaDTO racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public BankaDTO getRacunNalogodavca() {
		return racunNalogodavca;
	}

	public void setRacunNalogodavca(BankaDTO racunNalogodavca) {
		this.racunNalogodavca = racunNalogodavca;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
