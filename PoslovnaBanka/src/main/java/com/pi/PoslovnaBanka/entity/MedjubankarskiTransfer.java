package com.pi.PoslovnaBanka.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medjubankarskiTransferi")
public class MedjubankarskiTransfer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medjubankarski_transfer_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "ukupan_iznos", unique = false, nullable = false)
	private double ukupanIznos;
	
	@Column(name = "tip", unique = false, nullable = false)
	private String tip;
	
	@ManyToOne
    @JoinColumn(name = "transakcija", referencedColumnName = "transakcija_id", nullable=true)
	private Transakcija transakcija;
	
	@ManyToOne
    @JoinColumn(name = "racun_poverioca", referencedColumnName = "banka_id", nullable=false)
	private Banka racunPoverioca;
	
	@ManyToOne
    @JoinColumn(name = "racun_nalogodavca", referencedColumnName = "banka_id", nullable=false)
	private Banka racunNalogodavca;
	
	public MedjubankarskiTransfer() {
		super();
	}

	public MedjubankarskiTransfer(int id, double ukupanIznos, String tip, Transakcija transakcija, Banka racunPoverioca,
			Banka racunNalogodavca) {
		super();
		this.id = id;
		this.ukupanIznos = ukupanIznos;
		this.tip = tip;
		this.transakcija = transakcija;
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Transakcija getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(Transakcija transakcija) {
		this.transakcija = transakcija;
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
