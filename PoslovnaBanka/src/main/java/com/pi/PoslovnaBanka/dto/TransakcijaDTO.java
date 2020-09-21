package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.sql.Date;

import com.pi.PoslovnaBanka.entity.SmerTransakcije;
import com.pi.PoslovnaBanka.entity.Status;
import com.pi.PoslovnaBanka.entity.TipGreske;
import com.pi.PoslovnaBanka.entity.Transakcija;


public class TransakcijaDTO implements Serializable {

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
	private boolean hitno;
	private double iznos;
	private TipGreske tipGreske;
	private Status status;
	private SmerTransakcije smerTransakcije;
	private NaseljenoMestoDTO naseljenoMesto;
	private ValutaDTO valuta;
	private DnevnoStanjeDTO dnevnoStanjeRacuna;
	private VrstaPlacanjaDTO vrstaPlacanja;
	
	public TransakcijaDTO(int brojStavke, String duznik, String svrhaPlacanja, String poverilac, Date datumPrijema,
			Date datumValute, String racunDuznika, int modelZaduzenja, String pozivNaBrojZaduzenja,
			String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja, boolean hitno, double iznos,
			TipGreske tipGreske, Status status, SmerTransakcije smerTransakcije, NaseljenoMestoDTO naseljenoMesto, ValutaDTO valuta,
			DnevnoStanjeDTO dnevnoStanjeRacuna, VrstaPlacanjaDTO vrstaPlacanja) {
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
		this.hitno = hitno;
		this.iznos = iznos;
		this.tipGreske = tipGreske;
		this.status = status;
		this.smerTransakcije = smerTransakcije;
		this.naseljenoMesto = naseljenoMesto;
		this.valuta = valuta;
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
		this.vrstaPlacanja = vrstaPlacanja;
	}

	public TransakcijaDTO() {
		super();
	}

	public TransakcijaDTO(Transakcija transakcija) {
		this(transakcija.getBrojStavke(), transakcija.getDuznik(), transakcija.getSvrhaPlacanja(), transakcija.getPoverilac(),
				transakcija.getDatumPrijema(), transakcija.getDatumValute(), transakcija.getRacunDuznika(), transakcija.getModelZaduzenja(),
				transakcija.getPozivNaBrojZaduzenja(), transakcija.getRacunPoverioca(), transakcija.getModelOdobrenja(),
				transakcija.getPozivNaBrojOdobrenja(), transakcija.isHitno(), transakcija.getIznos(), transakcija.getTipGreske(),
				transakcija.getStatus(), transakcija.getSmer(),
				new NaseljenoMestoDTO(transakcija.getNaseljenoMesto()), new ValutaDTO(transakcija.getValuta()), 
				new DnevnoStanjeDTO(transakcija.getDnevnoStanjeRacuna()), new VrstaPlacanjaDTO(transakcija.getVrstaPlacanja()));
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

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public TipGreske getTipGreske() {
		return tipGreske;
	}

	public void setTipGreske(TipGreske tipGreske) {
		this.tipGreske = tipGreske;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public NaseljenoMestoDTO getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMestoDTO naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	public ValutaDTO getValuta() {
		return valuta;
	}

	public void setValuta(ValutaDTO valuta) {
		this.valuta = valuta;
	}

	public DnevnoStanjeDTO getDnevnoStanjeRacuna() {
		return dnevnoStanjeRacuna;
	}

	public void setDnevnoStanjeRacuna(DnevnoStanjeDTO dnevnoStanjeRacuna) {
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
	}

	public VrstaPlacanjaDTO getVrstaPlacanja() {
		return vrstaPlacanja;
	}

	public void setVrstaPlacanja(VrstaPlacanjaDTO vrstaPlacanja) {
		this.vrstaPlacanja = vrstaPlacanja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SmerTransakcije getSmerTransakcije() {
		return smerTransakcije;
	}

	public void setSmerTransakcije(SmerTransakcije smerTransakcije) {
		this.smerTransakcije = smerTransakcije;
	}
}
