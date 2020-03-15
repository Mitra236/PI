package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;

import com.pi.PoslovnaBanka.entity.KursUValuti;

public class KursUValutiDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int redniBroj;
	private double kupovni;
	private double srednji;
	private double prodajni;
	private KursnaListaDTO kursnaLista;
	private ValutaDTO valuta;
	
	public KursUValutiDTO(int redniBroj, double kupovni, double srednji, double prodajni, KursnaListaDTO kursnaLista,
			ValutaDTO valuta) {
		super();
		this.redniBroj = redniBroj;
		this.kupovni = kupovni;
		this.srednji = srednji;
		this.prodajni = prodajni;
		this.kursnaLista = kursnaLista;
		this.valuta = valuta;
	}

	public KursUValutiDTO() {
		super();
	}
	
	public KursUValutiDTO(KursUValuti kursUValuti) {
		this(kursUValuti.getRedniBroj(), kursUValuti.getKupovni(), kursUValuti.getSrednji(), kursUValuti.getProdajni(), 
				new KursnaListaDTO(kursUValuti.getKursnaLista()), new ValutaDTO(kursUValuti.getValuta()));
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	public KursnaListaDTO getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(KursnaListaDTO kursnaLista) {
		this.kursnaLista = kursnaLista;
	}

	public ValutaDTO getValuta() {
		return valuta;
	}

	public void setValuta(ValutaDTO valuta) {
		this.valuta = valuta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
