package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.Poruka;
import com.pi.PoslovnaBanka.entity.PorukeUPaketu;
import com.pi.PoslovnaBanka.entity.VrstaPoruke;

public class PorukaTransferDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private VrstaPoruke tip;
	private BankaTransferDTO racunPoverioca;
	private BankaTransferDTO racunNalogodavca;
	private ArrayList<PaketDTO> porukaPaket = new ArrayList<PaketDTO>();
	
	public PorukaTransferDTO() {
		super();
	}
	
	public PorukaTransferDTO(int id, VrstaPoruke tip, BankaTransferDTO racunPoverioca,
			BankaTransferDTO racunNalogodavca, ArrayList<PaketDTO> porukaPaket) {
		super();
		this.id = id;
		this.tip = tip;
		this.racunPoverioca = racunPoverioca;
		this.racunNalogodavca = racunNalogodavca;
		this.porukaPaket = porukaPaket;
	}

	public PorukaTransferDTO(Poruka poruka) {
		this(poruka.getId(), poruka.getTip(), 
				new BankaTransferDTO(poruka.getRacunPoverioca()), new BankaTransferDTO(poruka.getRacunNalogodavca()), 
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

	public BankaTransferDTO getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(BankaTransferDTO racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public BankaTransferDTO getRacunNalogodavca() {
		return racunNalogodavca;
	}

	public void setRacunNalogodavca(BankaTransferDTO racunNalogodavca) {
		this.racunNalogodavca = racunNalogodavca;
	}

	public ArrayList<PaketDTO> getPorukaPaket() {
		return porukaPaket;
	}

	public void setPorukaPaket(ArrayList<PaketDTO> porukaPaket) {
		this.porukaPaket = porukaPaket;
	}

	public VrstaPoruke getTip() {
		return tip;
	}

	public void setTip(VrstaPoruke tip) {
		this.tip = tip;
	}	
}
