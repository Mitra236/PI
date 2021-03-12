package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.Poruka;
import com.pi.PoslovnaBanka.entity.PorukeUPaketu;
import com.pi.PoslovnaBanka.entity.VrstaPoruke;

public class PorukaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private double ukupanIznos;
	private VrstaPoruke tip;
	private BankaDTO racunPoverioca;
	private BankaDTO racunNalogodavca;
	private ArrayList<PaketDTO> porukaPaket = new ArrayList<PaketDTO>();
	
	public PorukaDTO(int id, double ukupanIznos, VrstaPoruke tip, BankaDTO racunPoverioca, BankaDTO racunNalogodavca,
			ArrayList<PaketDTO> porukaPaket) {
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
				new BankaDTO(poruka.getRacunPoverioca()), new BankaDTO(poruka.getRacunNalogodavca()), 
				getPoruke(poruka));
	}
	
	private static ArrayList<PaketDTO> getPoruke(Poruka poruka) {
		ArrayList<PaketDTO> poruke = new ArrayList<>();
		for(PorukeUPaketu paket: poruka.getPorukaPaket()) {
			poruke.add(new PaketDTO(paket));
		}
		return poruke;
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
	public ArrayList<PaketDTO> getPorukaPaket() {
		return porukaPaket;
	}
	public void setPorukaPaket(ArrayList<PaketDTO> porukaPaket) {
		this.porukaPaket = porukaPaket;
	}
}
