package com.pi.PoslovnaBanka.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import com.pi.PoslovnaBanka.entity.KursnaLista;


public class KursnaListaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private Date datum;
	private int brojKursneListe;
	private Date primenjujeSeOd;
	private BankaDTO banka;
	private ArrayList<KursUValutiDTO> kursUValuti = new ArrayList<KursUValutiDTO>();
	
	public KursnaListaDTO(int id, Date datum, int brojKursneListe, Date primenjujeSeOd, BankaDTO banka,
			ArrayList<KursUValutiDTO> kursUValuti) {
		super();
		this.id = id;
		this.datum = datum;
		this.brojKursneListe = brojKursneListe;
		this.primenjujeSeOd = primenjujeSeOd;
		this.banka = banka;
		this.kursUValuti = kursUValuti;
	}

	public KursnaListaDTO() {
		super();
	}
	
	public KursnaListaDTO(KursnaLista kursnaLista) {
		this(kursnaLista.getId(), kursnaLista.getDatum(), kursnaLista.getBrojKursneListe(), kursnaLista.getPrimenjujeSeOd(),
				new BankaDTO(kursnaLista.getBanka()), new ArrayList<KursUValutiDTO>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getBrojKursneListe() {
		return brojKursneListe;
	}

	public void setBrojKursneListe(int brojKursneListe) {
		this.brojKursneListe = brojKursneListe;
	}

	public Date getPrimenjujeSeOd() {
		return primenjujeSeOd;
	}

	public void setPrimenjujeSeOd(Date primenjujeSeOd) {
		this.primenjujeSeOd = primenjujeSeOd;
	}

	public BankaDTO getBanka() {
		return banka;
	}

	public void setBanka(BankaDTO banka) {
		this.banka = banka;
	}

	public ArrayList<KursUValutiDTO> getKursUValuti() {
		return kursUValuti;
	}

	public void setKursUValuti(ArrayList<KursUValutiDTO> kursUValuti) {
		this.kursUValuti = kursUValuti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
