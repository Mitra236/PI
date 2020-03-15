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

@Entity
@Table(name = "drzave")
public class Drzava implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drzava_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "naziv_drzave", unique = true, nullable = false)
	private String naziv;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "drzava")
	private Set<NaseljenoMesto> drzava = new HashSet<NaseljenoMesto>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "drzava")
	private Set<Valuta> valuta = new HashSet<Valuta>();
	
	public Drzava() {
		super();
	}
	
	public Drzava(int id, String naziv, Set<NaseljenoMesto> drzava, Set<Valuta> valuta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzava = drzava;
		this.valuta = valuta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<NaseljenoMesto> getDrzava() {
		return drzava;
	}

	public void setDrzava(Set<NaseljenoMesto> drzava) {
		this.drzava = drzava;
	}

	public Set<Valuta> getValuta() {
		return valuta;
	}

	public void setValuta(Set<Valuta> valuta) {
		this.valuta = valuta;
	}
		
}
