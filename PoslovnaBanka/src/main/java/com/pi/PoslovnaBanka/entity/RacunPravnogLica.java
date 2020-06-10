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
@Table(name = "racuniPravnihLica")
public class RacunPravnogLica implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "racun_pravnog_lica_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "broj_racuna", unique = true, nullable = false)
	private String brojRacuna;
	
	@Column(name = "datum_otvaranja", unique = false, nullable = false)
	private Date datumOtvaranja;
	
	@Column(name = "vazeci", unique = false, nullable = false)
	private boolean vazeci;
	
	@ManyToOne
    @JoinColumn(name = "valuta", referencedColumnName = "valuta_id", nullable=false)
	private Valuta valuta;
	
	@ManyToOne
    @JoinColumn(name = "banka", referencedColumnName = "banka_id", nullable=false)
	private Banka banka;
	
	@ManyToOne
    @JoinColumn(name = "ukidanje", referencedColumnName = "ukidanje_id", nullable=false)
	private Ukidanje ukidanje;
	
	@ManyToOne
    @JoinColumn(name = "klijent", referencedColumnName = "klijent_id", nullable=false)
	private Klijent klijent;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "racunPravnogLica")
	private Set<DnevnoStanjeRacuna> dnevnoStanjeRacuna = new HashSet<DnevnoStanjeRacuna>();
	
	public RacunPravnogLica() {
		super();
	}
	
	public RacunPravnogLica(int id, String brojRacuna, Date datumOtvaranja, boolean vazeci, Valuta valuta,
			Banka banka, Ukidanje ukidanje, Klijent klijent, Set<DnevnoStanjeRacuna> dnevnoStanjeRacuna) {
		super();
		this.id = id;
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
		this.valuta = valuta;
		this.banka = banka;
		this.ukidanje = ukidanje;
		this.klijent = klijent;
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public boolean isVazeci() {
		return vazeci;
	}

	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public Ukidanje getUkidanje() {
		return ukidanje;
	}

	public void setUkidanje(Ukidanje ukidanje) {
		this.ukidanje = ukidanje;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Set<DnevnoStanjeRacuna> getDnevnoStanjeRacuna() {
		return dnevnoStanjeRacuna;
	}

	public void setDnevnoStanjeRacuna(Set<DnevnoStanjeRacuna> dnevnoStanjeRacuna) {
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
	}
}
