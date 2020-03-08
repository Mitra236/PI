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
@Table(name = "vrstePlacanja")
public class VrstaPlacanja implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vrsta_placanja_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "oznaka_vrste", unique = true, nullable = false)
	private String oznakaVrste;
	
	@Column(name = "naziv_vrste", unique = true, nullable = false)
	private String nazivVrste;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "vrstaPlacanja")
	private Set<Transakcija> transakcija = new HashSet<Transakcija>();
	
	public VrstaPlacanja() {
		super();
	}

	public VrstaPlacanja(int id, String oznakaVrste, String nazivVrste, Set<Transakcija> transakcija) {
		super();
		this.id = id;
		this.oznakaVrste = oznakaVrste;
		this.nazivVrste = nazivVrste;
		this.transakcija = transakcija;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOznakaVrste() {
		return oznakaVrste;
	}

	public void setOznakaVrste(String oznakaVrste) {
		this.oznakaVrste = oznakaVrste;
	}

	public String getNazivVrste() {
		return nazivVrste;
	}

	public void setNazivVrste(String nazivVrste) {
		this.nazivVrste = nazivVrste;
	}

	public Set<Transakcija> getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(Set<Transakcija> transakcija) {
		this.transakcija = transakcija;
	}
}
