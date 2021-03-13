package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.RacunPravnogLica;

public class RacunPravnogLicaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String brojRacuna;
	private Date datumOtvaranja;
	private boolean vazeci;
	private ValutaDTO valuta;
	private BankaDTO banka;
	private UkidanjeDTO ukidanje;
	private RacunPravnogLicaKlijentDTO klijent;
	private ArrayList<DnevnoStanjeDTO> dnevnoStanjeRacuna = new ArrayList<DnevnoStanjeDTO>();
	
	public RacunPravnogLicaDTO(int id, String brojRacuna, Date datumOtvaranja, boolean vazeci, ValutaDTO valuta,
			BankaDTO banka, UkidanjeDTO ukidanje, RacunPravnogLicaKlijentDTO klijent, ArrayList<DnevnoStanjeDTO> dnevnoStanjeRacuna) {
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

	public RacunPravnogLicaDTO() {
		super();
	}
	
	public RacunPravnogLicaDTO(RacunPravnogLica racunPravnogLica) {
		this(racunPravnogLica.getId(), racunPravnogLica.getBrojRacuna(), racunPravnogLica.getDatumOtvaranja(), racunPravnogLica.isVazeci(),
				new ValutaDTO(racunPravnogLica.getValuta()), new BankaDTO(racunPravnogLica.getBanka()),
				null, new RacunPravnogLicaKlijentDTO(racunPravnogLica.getKlijent()), new ArrayList<DnevnoStanjeDTO>());
		if(racunPravnogLica.getUkidanje() != null) {
			this.setUkidanje(new UkidanjeDTO(racunPravnogLica.getUkidanje()));
		}
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

	public ValutaDTO getValuta() {
		return valuta;
	}

	public void setValuta(ValutaDTO valuta) {
		this.valuta = valuta;
	}

	public BankaDTO getBanka() {
		return banka;
	}

	public void setBanka(BankaDTO banka) {
		this.banka = banka;
	}

	public UkidanjeDTO getUkidanje() {
		return ukidanje;
	}

	public void setUkidanje(UkidanjeDTO ukidanje) {
		this.ukidanje = ukidanje;
	}

	public RacunPravnogLicaKlijentDTO getKlijent() {
		return klijent;
	}

	public void setKlijent(RacunPravnogLicaKlijentDTO klijent) {
		this.klijent = klijent;
	}

	public ArrayList<DnevnoStanjeDTO> getDnevnoStanjeRacuna() {
		return dnevnoStanjeRacuna;
	}

	public void setDnevnoStanjeRacuna(ArrayList<DnevnoStanjeDTO> dnevnoStanjeRacuna) {
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
