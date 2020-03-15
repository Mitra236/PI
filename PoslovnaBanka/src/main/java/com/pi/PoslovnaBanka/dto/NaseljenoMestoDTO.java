package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.NaseljenoMesto;

public class NaseljenoMestoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String sifra;
	private String naziv;
	private String PTT;
	private DrzavaDTO drzava;
	private ArrayList<TransakcijaDTO> transakcija = new ArrayList<TransakcijaDTO>();
	
	public NaseljenoMestoDTO(int id, String sifra, String naziv, String pTT, DrzavaDTO drzava,
			ArrayList<TransakcijaDTO> transakcija) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.naziv = naziv;
		this.PTT = pTT;
		this.drzava = drzava;
		this.transakcija = transakcija;
	}

	public NaseljenoMestoDTO() {
		super();
	}
	
	public NaseljenoMestoDTO(NaseljenoMesto naseljenoMesto) {
		this(naseljenoMesto.getId(), naseljenoMesto.getSifra(), naseljenoMesto.getNaziv(), naseljenoMesto.getPTT(), 
				new DrzavaDTO(naseljenoMesto.getDrzava()), new ArrayList<TransakcijaDTO>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPTT() {
		return PTT;
	}

	public void setPTT(String pTT) {
		PTT = pTT;
	}

	public DrzavaDTO getDrzava() {
		return drzava;
	}

	public void setDrzava(DrzavaDTO drzava) {
		this.drzava = drzava;
	}

	public ArrayList<TransakcijaDTO> getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(ArrayList<TransakcijaDTO> transakcija) {
		this.transakcija = transakcija;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
