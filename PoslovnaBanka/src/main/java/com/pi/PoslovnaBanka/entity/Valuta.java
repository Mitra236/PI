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
@Table(name = "valute")
public class Valuta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "valuta_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "zvanicna_sifra", unique = true, nullable = false)
	private String zvanicnaSifra;
	
	@Column(name = "naziv", unique = true, nullable = false)
	private String naziv;
	
	@Column(name = "domicilna", unique = false, nullable = false)
	private boolean domicilna;
	
	@ManyToOne
    @JoinColumn(name = "valuta", referencedColumnName = "valuta_id", nullable=false)
	private Valuta valuta;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "valuta")
	private Set<KursUValuti> kursUValuti = new HashSet<KursUValuti>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "valuta")
	private Set<Transakcija> transakcija = new HashSet<Transakcija>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "valuta")
	private Set<RacunPravnogLica> racunPravnogLica = new HashSet<RacunPravnogLica>();
	
	public Valuta() {
		super();
	}

	public Valuta(int id, String zvanicnaSifra, String naziv, boolean domicilna, Valuta valuta,
			Set<KursUValuti> kursUValuti, Set<Transakcija> transakcija, Set<RacunPravnogLica> racunPravnogLica) {
		super();
		this.id = id;
		this.zvanicnaSifra = zvanicnaSifra;
		this.naziv = naziv;
		this.domicilna = domicilna;
		this.valuta = valuta;
		this.kursUValuti = kursUValuti;
		this.transakcija = transakcija;
		this.racunPravnogLica = racunPravnogLica;
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

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public Set<KursUValuti> getKursUValuti() {
		return kursUValuti;
	}

	public void setKursUValuti(Set<KursUValuti> kursUValuti) {
		this.kursUValuti = kursUValuti;
	}

	public Set<Transakcija> getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(Set<Transakcija> transakcija) {
		this.transakcija = transakcija;
	}

	public Set<RacunPravnogLica> getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(Set<RacunPravnogLica> racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}
	
}
