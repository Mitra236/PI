package com.pi.PoslovnaBanka.entity;

import java.io.Serializable;
import java.sql.Date;
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

@Entity
@Table(name = "ukidanja")
public class Ukidanje implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ukidanje_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "datum_ukidanja", unique = false, nullable = false)
	private Date datumUkidanja;
	
	@Column(name = "sredstva_se_prenose_na_racun", unique = true, nullable = false)
	private String sredstvaSePrenoseNaRacun;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "ukidanje")
	private Set<RacunPravnogLica> racunPravnogLica = new HashSet<RacunPravnogLica>();
	
	public Ukidanje() {
		super();
	}

	public Ukidanje(int id, Date datumUkidanja, String sredstvaSePrenoseNaRacun,
			Set<RacunPravnogLica> racunPravnogLica) {
		super();
		this.id = id;
		this.datumUkidanja = datumUkidanja;
		this.sredstvaSePrenoseNaRacun = sredstvaSePrenoseNaRacun;
		this.racunPravnogLica = racunPravnogLica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumUkidanja() {
		return datumUkidanja;
	}

	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}

	public String getSredstvaSePrenoseNaRacun() {
		return sredstvaSePrenoseNaRacun;
	}

	public void setSredstvaSePrenoseNaRacun(String sredstvaSePrenoseNaRacun) {
		this.sredstvaSePrenoseNaRacun = sredstvaSePrenoseNaRacun;
	}

	public Set<RacunPravnogLica> getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(Set<RacunPravnogLica> racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}
}
