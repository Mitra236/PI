package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.Klijent;

public class KlijentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String ime;
	private String prezime;
	private String JMBG;
	private String email;
	private String telefon;
	private String adresa;
	private ArrayList<RacunPravnogLicaDTO> racunPravnogLica = new ArrayList<RacunPravnogLicaDTO>();
	
	public KlijentDTO(int id, String ime, String prezime, String jMBG, String email, String telefon, String adresa,
			ArrayList<RacunPravnogLicaDTO> racunPravnogLica) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.JMBG = jMBG;
		this.email = email;
		this.telefon = telefon;
		this.adresa = adresa;
		this.racunPravnogLica = racunPravnogLica;
	}

	public KlijentDTO() {
		super();
	}
	
	public KlijentDTO(Klijent klijent) {
		this(klijent.getId(), klijent.getIme(), klijent.getPrezime(), klijent.getJMBG(), klijent.getEmail(), klijent.getTelefon(),
				klijent.getAdresa(), new ArrayList<RacunPravnogLicaDTO>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
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
