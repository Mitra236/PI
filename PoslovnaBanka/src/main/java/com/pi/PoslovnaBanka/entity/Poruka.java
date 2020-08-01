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
@Table(name = "poruke")
public class Poruka implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poruka_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "ukupan_iznos", unique = false, nullable = false)
	private double ukupanIznos;
	
	@Column(name = "tip", unique = false, nullable = false)
	private VrstaPoruke tip;
	
	@ManyToOne
    @JoinColumn(name = "racun_poverioca", referencedColumnName = "banka_id", nullable=false)
	private Banka racunPoverioca;
	
	@ManyToOne
    @JoinColumn(name = "racun_nalogodavca", referencedColumnName = "banka_id", nullable=false)
	private Banka racunNalogodavca;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "poruka")
	private Set<PorukeUPaketu> porukaPaket = new HashSet<PorukeUPaketu>();
	
	public Poruka() {
		super();
	}

	public Poruka(int id, double ukupanIznos, VrstaPoruke tip, Banka racunPoverioca,
			Banka racunNalogodavca) {
		super();
		this.id = id;
		this.ukupanIznos = ukupanIznos;
		this.tip = tip;
		this.racunPoverioca = racunPoverioca;
		this.racunNalogodavca = racunNalogodavca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public VrstaPoruke getTip() {
		return tip;
	}

	public void setTip(VrstaPoruke tip) {
		this.tip = tip;
	}

	public Banka getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(Banka racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public Banka getRacunNalogodavca() {
		return racunNalogodavca;
	}

	public void setRacunNalogodavca(Banka racunNalogodavca) {
		this.racunNalogodavca = racunNalogodavca;
	}
}
