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
@Table(name = "poruka_u_paketu")
public class PorukeUPaketu implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poruka_u_paketu_id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "poruka", referencedColumnName = "poruka_id", nullable=false)
	private Poruka poruka;
	
	@ManyToOne
    @JoinColumn(name = "transakcija", referencedColumnName = "transakcija_id", nullable=false)
	private Transakcija transakcija;

	public PorukeUPaketu() {
		super();
	}

	public PorukeUPaketu(int id, Poruka poruka, Transakcija transakcija) {
		super();
		this.id = id;
		this.poruka = poruka;
		this.transakcija = transakcija;
	}

	public Poruka getPoruka() {
		return poruka;
	}

	public void setPoruka(Poruka poruka) {
		this.poruka = poruka;
	}

	public int getId() {
		return id;
	}

	public Transakcija getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(Transakcija transakcija) {
		this.transakcija = transakcija;
	}
}
