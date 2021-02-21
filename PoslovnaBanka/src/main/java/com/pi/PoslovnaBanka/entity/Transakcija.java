package com.pi.PoslovnaBanka.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "transakcije")
public class Transakcija implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transakcija_id", unique = true, nullable = false)
	private int brojStavke;
	
	@Column(name = "duznik", unique = false, nullable = false)
	private String duznik;
	
	@Column(name = "svrha_placanja", unique = false, nullable = false)
	private String svrhaPlacanja;
	
	@Column(name = "poverilac", unique = false, nullable = false)
	private String poverilac;
	
	@Column(name = "datum_prijema", unique = false, nullable = false)
	private Date datumPrijema;
	
	@Column(name = "datum_valute", unique = false, nullable = false)
	private Date datumValute;
	
	@Column(name = "racun_duznika", unique = false, nullable = false)
	private String racunDuznika;
	
	@Column(name = "model_zaduzenja", unique = false, nullable = false)
	private int modelZaduzenja;
	
	@Column(name = "poziv_na_broj_zaduzenja", unique = false, nullable = false)
	private String pozivNaBrojZaduzenja;
	
	@Column(name = "racun_poverioca", unique = false, nullable = false)
	private String racunPoverioca;
	
	@Column(name = "model_odobrenja", unique = false, nullable = false)
	private int modelOdobrenja;
	
	@Column(name = "poziv_na_broj_odobrenja", unique = false, nullable = false)
	private String pozivNaBrojOdobrenja;
	
	@Column(name = "hitno", unique = false, nullable = false)
	private boolean hitno;
	
	@Column(name = "iznos", unique = false, nullable = false)
	private double iznos;
	
	@Column(name = "tip_greske", unique = false, nullable = true)
	private TipGreske tipGreske;
	
	@Column(name = "status", unique = false, nullable = true)
	private Status status;
	
	@Column(name = "smer", unique = false, nullable = true)
	private SmerTransakcije smer;
	
	@ManyToOne
    @JoinColumn(name = "naseljeno_mesto", referencedColumnName = "naseljeno_mesto_id", nullable=true)
	private NaseljenoMesto naseljenoMesto;
	
	@ManyToOne
    @JoinColumn(name = "valuta", referencedColumnName = "valuta_id", nullable=true)
	private Valuta valuta;
	
	@ManyToOne
    @JoinColumn(name = "dnevno_stanje_racuna", referencedColumnName = "dnevno_stanje_racuna_id", nullable=true)
	private DnevnoStanjeRacuna dnevnoStanjeRacuna;
	
	@ManyToOne
    @JoinColumn(name = "vrsta_placanja", referencedColumnName = "vrsta_placanja_id", nullable=true)
	private VrstaPlacanja vrstaPlacanja;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "transakcija")
	private Set<PorukeUPaketu> porukaPaket = new HashSet<PorukeUPaketu>();
	
	public Transakcija(int brojStavke, String duznik, String svrhaPlacanja, String poverilac, Date datumPrijema,
			Date datumValute, String racunDuznika, int modelZaduzenja, String pozivNaBrojZaduzenja,
			String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja, boolean hitno, double iznos,
			TipGreske tipGreske, Status status, SmerTransakcije smer, NaseljenoMesto naseljenoMesto, Valuta valuta,
			DnevnoStanjeRacuna dnevnoStanjeRacuna, VrstaPlacanja vrstaPlacanja, Set<PorukeUPaketu> porukaPaket) {
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
		this.smer = smer;
		this.naseljenoMesto = naseljenoMesto;
		this.valuta = valuta;
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
		this.vrstaPlacanja = vrstaPlacanja;
		this.porukaPaket = porukaPaket;
	}

	public Set<PorukeUPaketu> getPorukaPaket() {
		return porukaPaket;
	}

	public void setPorukaPaket(Set<PorukeUPaketu> porukaPaket) {
		this.porukaPaket = porukaPaket;
	}

	public Transakcija() {
		super();
	}

	public Transakcija(int brojStavke, String duznik, String svrhaPlacanja, String poverilac, Date datumPrijema,
			Date datumValute, String racunDuznika, int modelZaduzenja, String pozivNaBrojZaduzenja,
			String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja, boolean hitno, double iznos,
			TipGreske tipGreske, Status status, NaseljenoMesto naseljenoMesto, Valuta valuta,
			DnevnoStanjeRacuna dnevnoStanjeRacuna, VrstaPlacanja vrstaPlacanja) {
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
		this.naseljenoMesto = naseljenoMesto;
		this.valuta = valuta;
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
		this.vrstaPlacanja = vrstaPlacanja;
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

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public DnevnoStanjeRacuna getDnevnoStanjeRacuna() {
		return dnevnoStanjeRacuna;
	}

	public void setDnevnoStanjeRacuna(DnevnoStanjeRacuna dnevnoStanjeRacuna) {
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
	}

	public VrstaPlacanja getVrstaPlacanja() {
		return vrstaPlacanja;
	}

	public void setVrstaPlacanja(VrstaPlacanja vrstaPlacanja) {
		this.vrstaPlacanja = vrstaPlacanja;
	}

	public SmerTransakcije getSmer() {
		return smer;
	}

	public void setSmer(SmerTransakcije smer) {
		this.smer = smer;
	}
}
