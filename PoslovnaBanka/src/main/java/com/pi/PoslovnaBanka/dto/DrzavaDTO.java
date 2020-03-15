package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.Drzava;

public class DrzavaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String naziv;
	private ArrayList<NaseljenoMestoDTO> naseljenoMesto = new ArrayList<NaseljenoMestoDTO>();
	private ArrayList<ValutaDTO> valuta = new ArrayList<ValutaDTO>();
	
	public DrzavaDTO(int id, String naziv, ArrayList<NaseljenoMestoDTO> naseljenoMesto, ArrayList<ValutaDTO> valuta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.naseljenoMesto = naseljenoMesto;
		this.valuta = valuta;
	}

	public DrzavaDTO(Drzava drzava) {
		this(drzava.getId(), drzava.getNaziv(), new ArrayList<NaseljenoMestoDTO>(), new ArrayList<ValutaDTO>());
	}
	public DrzavaDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArrayList<NaseljenoMestoDTO> getDrzava() {
		return naseljenoMesto;
	}

	public void setDrzava(ArrayList<NaseljenoMestoDTO> drzava) {
		this.naseljenoMesto = drzava;
	}

	public ArrayList<ValutaDTO> getValuta() {
		return valuta;
	}

	public void setValuta(ArrayList<ValutaDTO> valuta) {
		this.valuta = valuta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
