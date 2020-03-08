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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "naseljenaMesta")
public class NaseljenoMesto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "naseljeno_mesto_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "sifra", unique = true, nullable = false)
	private String sifra;
	
	@Column(name = "naziv", unique = true, nullable = false)
	private String naziv;
	
	@Column(name = "ptt", unique = true, nullable = false)
	private String PTT;
	
	@ManyToOne
    @JoinColumn(name = "drzava", referencedColumnName = "drzava_id", nullable=false)
	private Drzava drzava;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "naseljenoMesto")
	private Set<Transakcija> transakcija = new HashSet<Transakcija>();
	
	public NaseljenoMesto() {
		super();
	}

	public NaseljenoMesto(int id, String sifra, String naziv, String pTT, Drzava drzava, Set<Transakcija> transakcija) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.naziv = naziv;
		PTT = pTT;
		this.drzava = drzava;
		this.transakcija = transakcija;
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

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	public Set<Transakcija> getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(Set<Transakcija> transakcija) {
		this.transakcija = transakcija;
	}

}
