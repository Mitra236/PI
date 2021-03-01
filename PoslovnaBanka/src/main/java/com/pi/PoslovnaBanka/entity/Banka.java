package com.pi.PoslovnaBanka.entity;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "banke" )
public class Banka implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "banka_id", unique = true, nullable = false)
	private int id;	
	
	@Column(name = "sifra_banke", unique = true, nullable = false, length = 3)
	private String sifraBanke;
	
	@Column(name = "naziv_banke", unique = true, nullable = false)
	private String naziv;	
	
	@Column(name = "pib", unique = true, nullable = false, length = 9)
	private String PIB;	
	
	@Column(name = "adresa", unique = false, nullable = false)
	private String adresa;
	
	@Email
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "web", unique = true, nullable = false)
	private String web;	
	
	@Column(name = "fax", unique = true, nullable = false)
	private String fax;
	
	@Column(name = "telefon", unique = true, nullable = false)
	private String telefon;
	
	@Column(name = "swift", unique = false, nullable = false)
	private String SWIFT;
	
	@Column(name = "stanje", unique = false, nullable = false)
	private double stanje;
	
	@Column(name = "vazeci", unique = false, nullable = false)
	private boolean vazeci;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "banka")
	private Set<KursnaLista> kursnaLista = new HashSet<KursnaLista>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "banka")
	private Set<RacunPravnogLica> racunPravnogLica = new HashSet<RacunPravnogLica>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "racunNalogodavca")
	private Set<Poruka> bankaNalogodavac = new HashSet<Poruka>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "racunPoverioca")
	private Set<Poruka> bankaPoverilac = new HashSet<Poruka>();
	
	public Banka() {
		super();
		
	}
	
	public Banka(int id, String sifraBanke, String naziv, String pIB, String adresa, @Email String email, String web,
			String fax, String telefon, String sWIFT, double stanje, Set<KursnaLista> kursnaLista,
			Set<RacunPravnogLica> racunPravnogLica, Set<Poruka> bankaNalogodavac, Set<Poruka> bankaPoverilac) {
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
		this.kursnaLista = kursnaLista;
		this.racunPravnogLica = racunPravnogLica;
		this.bankaNalogodavac = bankaNalogodavac;
		this.bankaPoverilac = bankaPoverilac;
	}
	
	



	public Banka(int id, String sifraBanke, String naziv, String pIB, String adresa, @Email String email, String web,
			String fax, String telefon, String sWIFT, double stanje, boolean vazeci, Set<KursnaLista> kursnaLista,
			Set<RacunPravnogLica> racunPravnogLica, Set<Poruka> bankaNalogodavac, Set<Poruka> bankaPoverilac) {
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

	public Banka(int id, String naziv) {
		this.id = id;
		this.naziv = naziv;
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

	public Set<KursnaLista> getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(Set<KursnaLista> kursnaLista) {
		this.kursnaLista = kursnaLista;
	}

	public Set<RacunPravnogLica> getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(Set<RacunPravnogLica> racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}

	public Set<Poruka> getBankaNalogodavac() {
		return bankaNalogodavac;
	}

	public void setBankaNalogodavac(Set<Poruka> bankaNalogodavac) {
		this.bankaNalogodavac = bankaNalogodavac;
	}

	public Set<Poruka> getBankaPoverilac() {
		return bankaPoverilac;
	}

	public void setBankaPoverilac(Set<Poruka> bankaPoverilac) {
		this.bankaPoverilac = bankaPoverilac;
	}

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}
}
