package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;

public class DnevnoStanjeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int brojIzvoda;
	private Date datumPoslednjegPrometa;
	private double prethodnoStanje;
	private double prometUKorist;
	private double prometNaTeret;
	private double trenutnoStanje;
	private RacunPravnogLicaDTO racunPravnogLica;
	private List<TransakcijaDTO> transakcija;
	
	public DnevnoStanjeDTO(int brojIzvoda, Date datumPoslednjegPrometa, double prethodnoStanje, double prometUKorist,
			double prometNaTeret, double trenutnoStanje, RacunPravnogLicaDTO racunPravnogLica, List<TransakcijaDTO> transakcija) {
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

	public DnevnoStanjeDTO() {
		super();
	}
	
	public DnevnoStanjeDTO(DnevnoStanjeRacuna dnevnoStanjeRacuna) {
		this(dnevnoStanjeRacuna.getBrojIzvoda(), dnevnoStanjeRacuna.getDatumPoslednjegPrometa(), dnevnoStanjeRacuna.getPrethodnoStanje(),
				dnevnoStanjeRacuna.getPrometUKorist(), dnevnoStanjeRacuna.getPrometNaTeret(), dnevnoStanjeRacuna.getTrenutnoStanje(),
				new RacunPravnogLicaDTO(dnevnoStanjeRacuna.getRacunPravnogLica()), new ArrayList());
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

	public RacunPravnogLicaDTO getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(RacunPravnogLicaDTO racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}

	public List<TransakcijaDTO> getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(List<TransakcijaDTO> transakcija) {
		this.transakcija = transakcija;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
