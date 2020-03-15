package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import com.pi.PoslovnaBanka.entity.Ukidanje;

public class UkidanjeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private Date datumUkidanja;
	private String sredstvaSePrenoseNaRacun;
	private ArrayList<RacunPravnogLicaDTO> racunPravnogLica = new ArrayList<RacunPravnogLicaDTO>();
	
	public UkidanjeDTO(int id, Date datumUkidanja, String sredstvaSePrenoseNaRacun,
			ArrayList<RacunPravnogLicaDTO> racunPravnogLica) {
		super();
		this.id = id;
		this.datumUkidanja = datumUkidanja;
		this.sredstvaSePrenoseNaRacun = sredstvaSePrenoseNaRacun;
		this.racunPravnogLica = racunPravnogLica;
	}

	public UkidanjeDTO() {
		super();
	}
	
	public UkidanjeDTO(Ukidanje ukidanje) {
		this(ukidanje.getId(), ukidanje.getDatumUkidanja(), ukidanje.getSredstvaSePrenoseNaRacun(), new ArrayList<RacunPravnogLicaDTO>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumUkidanja() {
		return datumUkidanja;
	}

	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}

	public String getSredstvaSePrenoseNaRacun() {
		return sredstvaSePrenoseNaRacun;
	}

	public void setSredstvaSePrenoseNaRacun(String sredstvaSePrenoseNaRacun) {
		this.sredstvaSePrenoseNaRacun = sredstvaSePrenoseNaRacun;
	}

	public ArrayList<RacunPravnogLicaDTO> getRacunPravnogLica() {
		return racunPravnogLica;
	}

	public void setRacunPravnogLica(ArrayList<RacunPravnogLicaDTO> racunPravnogLica) {
		this.racunPravnogLica = racunPravnogLica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
