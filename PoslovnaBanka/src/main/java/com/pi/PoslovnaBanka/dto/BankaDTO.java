package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.Banka;

public class BankaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;	
	private String sifraBanke;
	private String naziv;	
	private String PIB;	
	private String adresa;
	private String email;
	private String web;	
	private String fax;
	private String telefon;
	private String SWIFT;
	private double stanje;
	private boolean vazeci;
	private ArrayList<KursnaListaDTO> kursnaLista = new ArrayList<KursnaListaDTO>();
	private ArrayList<RacunPravnogLicaDTO> racunPravnogLica = new ArrayList<RacunPravnogLicaDTO>();
	private ArrayList<PorukaDTO> bankaNalogodavac = new ArrayList<PorukaDTO>();
	private ArrayList<PorukaDTO> bankaPoverilac = new ArrayList<PorukaDTO>();
	
	public BankaDTO(int id, String sifraBanke, String naziv, String pIB, String adresa, String email, String web,
			String fax, String telefon, String sWIFT, double stanje, ArrayList<KursnaListaDTO> kursnaLista,
			ArrayList<RacunPravnogLicaDTO> racunPravnogLica, ArrayList<PorukaDTO> bankaNalogodavac,
			ArrayList<PorukaDTO> bankaPoverilac) {
		super();
		this.id = id;
		this.sifraBanke = sifraBanke;
		this.naziv = naziv;
		PIB = pIB;
		this.adresa = adresa;
		this.email = email;
		this.web = web;
		this.fax = fax;
		this.telefon = telefon;
		SWIFT = sWIFT;
		this.kursnaLista = kursnaLista;
		this.racunPravnogLica = racunPravnogLica;
		this.bankaNalogodavac = bankaNalogodavac;
		this.bankaPoverilac = bankaPoverilac;
	}
	
	

	public BankaDTO(int id, String sifraBanke, String naziv, String pIB, String adresa, String email, String web,
			String fax, String telefon, String sWIFT, double stanje, boolean vazeci,
			ArrayList<KursnaListaDTO> kursnaLista, ArrayList<RacunPravnogLicaDTO> racunPravnogLica,
			ArrayList<PorukaDTO> bankaNalogodavac, ArrayList<PorukaDTO> bankaPoverilac) {
		super();
		this.id = id;
		this.sifraBanke = sifraBanke;
		this.naziv = naziv;
		PIB = pIB;
		this.adresa = adresa;
		this.email = email;
		this.web = web;
		this.fax = fax;
		this.telefon = telefon;
		SWIFT = sWIFT;
		this.stanje = stanje;
		this.vazeci = vazeci;
		this.kursnaLista = kursnaLista;
		this.racunPravnogLica = racunPravnogLica;
		this.bankaNalogodavac = bankaNalogodavac;
		this.bankaPoverilac = bankaPoverilac;
	}



	public BankaDTO() {
		super();
	}
	
	public BankaDTO(Banka banka) {
		this(banka.getId(), banka.getSifraBanke(), banka.getNaziv(), banka.getPIB(), 
				banka.getAdresa(), banka.getEmail(), banka.getWeb(), banka.getFax(), banka.getTelefon(),
				banka.getSWIFT(), banka.getStanje(), banka.isVazeci() ,new ArrayList<KursnaListaDTO>(), new ArrayList<RacunPravnogLicaDTO>(), 
				new ArrayList<PorukaDTO>(), new ArrayList<PorukaDTO>());
	}
	
	

	public boolean isVazeci() {
		return vazeci;
	}



	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSifraBanke() {
		return sifraBanke;
	}

	public void setSifraBanke(String sifraBanke) {
		this.sifraBanke = sifraBanke;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPIB() {
		return PIB;
	}

	public void setPIB(String pIB) {
		PIB = pIB;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getSWIFT() {
		return SWIFT;
	}

	public void setSWIFT(String sWIFT) {
		SWIFT = sWIFT;
	}

	public ArrayList<KursnaListaDTO> getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(ArrayList<KursnaListaDTO> kursnaLista) {
		this.kursnaLista = kursnaLista;
	}

	public ArrayList<RacunPravnogLicaDTO> getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(ArrayList<RacunPravnogLicaDTO> racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}

	public ArrayList<PorukaDTO> getBankaNalogodavac() {
		return bankaNalogodavac;
	}

	public void setBankaNalogodavac(ArrayList<PorukaDTO> bankaNalogodavac) {
		this.bankaNalogodavac = bankaNalogodavac;
	}

	public ArrayList<PorukaDTO> getBankaPoverilac() {
		return bankaPoverilac;
	}

	public void setBankaPoverilac(ArrayList<PorukaDTO> bankaPoverilac) {
		this.bankaPoverilac = bankaPoverilac;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}
}
