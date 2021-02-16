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
@Table(name = "klijenti")
public class Klijent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "klijent_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "ime", unique = false, nullable = false)
	private String ime;
	
	@Column(name = "prezime", unique = false, nullable = false)
	private String prezime;
	
	@Column(name = "jmbg", unique = true, nullable = false, length = 13)
	private String JMBG;
	
	@Column(name = "lozinka", unique = true, nullable = false)
	private String lozinka;
	
	@Email
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "telefon", unique = false, nullable = true)
	private String telefon;
	
	@Column(name = "adresa", unique = false, nullable = true)
	private String adresa;
	
	@Column(name = "uloga", unique = false, nullable = true)
	private Uloga uloga;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "klijent")
	private Set<RacunPravnogLica> racunPravnogLica = new HashSet<RacunPravnogLica>();
	
	public Klijent() {
		super();
	}

	public Klijent(int id, String ime, String prezime, String jMBG, String lozinka, @Email String email, String telefon, String adresa,
			Uloga uloga, Set<RacunPravnogLica> racunPravnogLica) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		JMBG = jMBG;
		this.lozinka = lozinka;
		this.email = email;
		this.telefon = telefon;
		this.adresa = adresa;
		this.uloga = uloga;
		this.racunPravnogLica = racunPravnogLica;
	}

	public int getId() {
		return id;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
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

	public Set<RacunPravnogLica> getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(Set<RacunPravnogLica> racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
}
