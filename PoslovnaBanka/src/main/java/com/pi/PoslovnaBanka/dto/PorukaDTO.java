package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.Poruka;
import com.pi.PoslovnaBanka.entity.VrstaPoruke;

public class PorukaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private double ukupanIznos;
	private VrstaPoruke tip;
	private BankaDTO racunPoverioca;
	private BankaDTO racunNalogodavca;
	private ArrayList<PorukeUPaketuDTO> porukaPaket = new ArrayList<PorukeUPaketuDTO>();
	
	public PorukaDTO(int id, double ukupanIznos, VrstaPoruke tip, BankaDTO racunPoverioca, BankaDTO racunNalogodavca,
			ArrayList<PorukeUPaketuDTO> porukaPaket) {
		super();
		this.id = id;
		this.ukupanIznos = ukupanIznos;
		this.tip = tip;
		this.racunPoverioca = racunPoverioca;
		this.racunNalogodavca = racunNalogodavca;
		this.porukaPaket = porukaPaket;
	}
	
	public PorukaDTO() {
		super();
	}

	public PorukaDTO(Poruka poruka) {
		this(poruka.getId(), poruka.getUkupanIznos(), poruka.getTip(), 
				new BankaDTO(poruka.getRacunPoverioca()), new BankaDTO(poruka.getRacunNalogodavca()), new ArrayList<PorukeUPaketuDTO>());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getUkupanIznos() {
		return ukupanIznos;
	}
	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}
	public VrstaPoruke getTip() {
		return tip;
	}
	public void setTip(VrstaPoruke tip) {
		this.tip = tip;
	}
	public BankaDTO getRacunPoverioca() {
		return racunPoverioca;
	}
	public void setRacunPoverioca(BankaDTO racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}
	public BankaDTO getRacunNalogodavca() {
		return racunNalogodavca;
	}
	public void setRacunNalogodavca(BankaDTO racunNalogodavca) {
		this.racunNalogodavca = racunNalogodavca;
	}
	public ArrayList<PorukeUPaketuDTO> getPorukaPaket() {
		return porukaPaket;
	}
	public void setPorukaPaket(ArrayList<PorukeUPaketuDTO> porukaPaket) {
		this.porukaPaket = porukaPaket;
	}
}
