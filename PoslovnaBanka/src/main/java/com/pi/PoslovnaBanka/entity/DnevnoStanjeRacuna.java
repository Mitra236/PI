package com.pi.PoslovnaBanka.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "dnevnoStanjeRacuna")
public class DnevnoStanjeRacuna implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dnevno_stanje_racuna_id", unique = true, nullable = false)
	private int brojIzvoda;
	
	@Column(name = "datum_poslednjeg_prometa", unique = false, nullable = false)
	private Date datumPoslednjegPrometa;
	
	@Column(name = "prethodno_stanje", unique = false, nullable = false)
	private double prethodnoStanje;
	
	@Column(name = "promet_u_korist", unique = false, nullable = false)
	private double prometUKorist;
	
	@Column(name = "promet_na_teret", unique = false, nullable = false)
	private double prometNaTeret;
	
	@Column(name = "trenutno_stanje", unique = false, nullable = false)
	private double trenutnoStanje;
	
	@ManyToOne
    @JoinColumn(name = "racun_pravnog_lica", referencedColumnName = "racun_pravnog_lica_id", nullable=false)
	private RacunPravnogLica racunPravnogLica;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "dnevnoStanjeRacuna")
	private List<Transakcija> transakcija;
	
	public DnevnoStanjeRacuna() {
		super();
	}

	public DnevnoStanjeRacuna(int brojIzvoda, Date datumPoslednjegPrometa, double prethodnoStanje, double prometUKorist,
			double prometNaTeret, double trenutnoStanje, RacunPravnogLica racunPravnogLica, List<Transakcija>  transakcija) {
		super();
		this.brojIzvoda = brojIzvoda;
		this.datumPoslednjegPrometa = datumPoslednjegPrometa;
		this.prethodnoStanje = prethodnoStanje;
		this.prometUKorist = prometUKorist;
		this.prometNaTeret = prometNaTeret;
		this.trenutnoStanje = trenutnoStanje;
		this.racunPravnogLica = racunPravnogLica;
		this.transakcija = transakcija;
	}

	public int getBrojIzvoda() {
		return brojIzvoda;
	}

	public void setBrojIzvoda(int brojIzvoda) {
		this.brojIzvoda = brojIzvoda;
	}

	public Date getDatumPoslednjegPrometa() {
		return datumPoslednjegPrometa;
	}

	public void setDatumPoslednjegPrometa(Date datumPoslednjegPrometa) {
		this.datumPoslednjegPrometa = datumPoslednjegPrometa;
	}

	public double getPrethodnoStanje() {
		return prethodnoStanje;
	}

	public void setPrethodnoStanje(double prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}

	public double getPrometUKorist() {
		return prometUKorist;
	}

	public void setPrometUKorist(double prometUKorist) {
		this.prometUKorist = prometUKorist;
	}

	public double getPrometNaTeret() {
		return prometNaTeret;
	}

	public void setPrometNaTeret(double prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}

	public double getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(double trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	public RacunPravnogLica getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(RacunPravnogLica racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}

	public List<Transakcija> getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(List<Transakcija> transakcija) {
		this.transakcija = transakcija;
	}
}
