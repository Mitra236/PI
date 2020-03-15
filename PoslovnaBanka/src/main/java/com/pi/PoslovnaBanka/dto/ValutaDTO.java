package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;
import com.pi.PoslovnaBanka.entity.Valuta;

public class ValutaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String zvanicnaSifra;
	private String naziv;
	private boolean domicilna;
	private DrzavaDTO drzava;
	private ArrayList<KursUValutiDTO> kursUValuti = new ArrayList<KursUValutiDTO>();
	private ArrayList<TransakcijaDTO> transakcija = new ArrayList<TransakcijaDTO>();
	private ArrayList<RacunPravnogLicaDTO> racunPravnogLica = new ArrayList<RacunPravnogLicaDTO>();
	
	public ValutaDTO(int id, String zvanicnaSifra, String naziv, boolean domicilna, DrzavaDTO drzava,
			ArrayList<KursUValutiDTO> kursUValuti, ArrayList<TransakcijaDTO> transakcija,
			ArrayList<RacunPravnogLicaDTO> racunPravnogLica) {
		super();
		this.id = id;
		this.zvanicnaSifra = zvanicnaSifra;
		this.naziv = naziv;
		this.domicilna = domicilna;
		this.drzava = drzava;
		this.kursUValuti = kursUValuti;
		this.transakcija = transakcija;
		this.racunPravnogLica = racunPravnogLica;
	}

	public ValutaDTO() {
		super();
	}
	
	public ValutaDTO(Valuta valuta) {
		this(valuta.getId(), valuta.getZvanicnaSifra(), valuta.getNaziv(), valuta.isDomicilna(), new DrzavaDTO(valuta.getDrzava()), 
				new ArrayList<KursUValutiDTO>(), new ArrayList<TransakcijaDTO>(), new ArrayList<RacunPravnogLicaDTO>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZvanicnaSifra() {
		return zvanicnaSifra;
	}

	public void setZvanicnaSifra(String zvanicnaSifra) {
		this.zvanicnaSifra = zvanicnaSifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public boolean isDomicilna() {
		return domicilna;
	}

	public void setDomicilna(boolean domicilna) {
		this.domicilna = domicilna;
	}

	public DrzavaDTO getDrzava() {
		return drzava;
	}

	public void setDrzava(DrzavaDTO drzava) {
		this.drzava = drzava;
	}

	public ArrayList<KursUValutiDTO> getKursUValuti() {
		return kursUValuti;
	}

	public void setKursUValuti(ArrayList<KursUValutiDTO> kursUValuti) {
		this.kursUValuti = kursUValuti;
	}

	public ArrayList<TransakcijaDTO> getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(ArrayList<TransakcijaDTO> transakcija) {
		this.transakcija = transakcija;
	}

	public ArrayList<RacunPravnogLicaDTO> getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(ArrayList<RacunPravnogLicaDTO> racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
