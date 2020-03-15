package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;
import com.pi.PoslovnaBanka.entity.VrstaPlacanja;

public class VrstaPlacanjaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String oznakaVrste;
	private String nazivVrste;
	private ArrayList<TransakcijaDTO> transakcija = new ArrayList<TransakcijaDTO>();
	
	public VrstaPlacanjaDTO(int id, String oznakaVrste, String nazivVrste, ArrayList<TransakcijaDTO> transakcija) {
		super();
		this.id = id;
		this.oznakaVrste = oznakaVrste;
		this.nazivVrste = nazivVrste;
		this.transakcija = transakcija;
	}

	public VrstaPlacanjaDTO() {
		super();
	}
	
	public VrstaPlacanjaDTO(VrstaPlacanja vrstaPlacanja) {
		this(vrstaPlacanja.getId(), vrstaPlacanja.getOznakaVrste(), vrstaPlacanja.getNazivVrste(), new ArrayList<TransakcijaDTO>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOznakaVrste() {
		return oznakaVrste;
	}

	public void setOznakaVrste(String oznakaVrste) {
		this.oznakaVrste = oznakaVrste;
	}

	public String getNazivVrste() {
		return nazivVrste;
	}

	public void setNazivVrste(String nazivVrste) {
		this.nazivVrste = nazivVrste;
	}

	public ArrayList<TransakcijaDTO> getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(ArrayList<TransakcijaDTO> transakcija) {
		this.transakcija = transakcija;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
