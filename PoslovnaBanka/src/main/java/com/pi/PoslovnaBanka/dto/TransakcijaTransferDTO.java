package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.sql.Date;

import com.pi.PoslovnaBanka.entity.Transakcija;

public class TransakcijaTransferDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private int brojStavke;
	private String duznik;
	private String svrhaPlacanja;
	private String poverilac;
	private Date datumPrijema;
	private Date datumValute;
	private String racunDuznika;
	private int modelZaduzenja;
	private String pozivNaBrojZaduzenja;
	private String racunPoverioca;
	private int modelOdobrenja;
	private String pozivNaBrojOdobrenja;
	private double iznos;
	
	public TransakcijaTransferDTO() {
		super();
	}
	
	public TransakcijaTransferDTO(int brojStavke, String duznik, String svrhaPlacanja, String poverilac,
			Date datumPrijema, Date datumValute, String racunDuznika, int modelZaduzenja, String pozivNaBrojZaduzenja,
			String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja, double iznos) {
		super();
		this.brojStavke = brojStavke;
		this.duznik = duznik;
		this.svrhaPlacanja = svrhaPlacanja;
		this.poverilac = poverilac;
		this.datumPrijema = datumPrijema;
		this.datumValute = datumValute;
		this.racunDuznika = racunDuznika;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
		this.racunPoverioca = racunPoverioca;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.iznos = iznos;
	}

	public TransakcijaTransferDTO(Transakcija transakcija) {
		this(transakcija.getBrojStavke(), transakcija.getDuznik(), transakcija.getSvrhaPlacanja(), transakcija.getPoverilac(),
				transakcija.getDatumPrijema(), transakcija.getDatumValute(), transakcija.getRacunDuznika(), transakcija.getModelZaduzenja(),
				transakcija.getPozivNaBrojZaduzenja(), transakcija.getRacunPoverioca(), transakcija.getModelOdobrenja(),
				transakcija.getPozivNaBrojOdobrenja(), transakcija.getIznos());
	}

	public int getBrojStavke() {
		return brojStavke;
	}

	public void setBrojStavke(int brojStavke) {
		this.brojStavke = brojStavke;
	}

	public String getDuznik() {
		return duznik;
	}

	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public String getPoverilac() {
		return poverilac;
	}

	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}

	public Date getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public int getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(int modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public int getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(int modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
}
