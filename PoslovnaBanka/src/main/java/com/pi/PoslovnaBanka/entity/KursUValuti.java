package com.pi.PoslovnaBanka.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kursUValuti")
public class KursUValuti implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kurs_u_valuti_id", unique = true, nullable = false)
	private int redniBroj;
	
	@Column(name = "kupovni", unique = false, nullable = false)
	private double kupovni;
	
	@Column(name = "srednji", unique = false, nullable = false)
	private double srednji;
	
	@Column(name = "prodajni", unique = false, nullable = false)
	private double prodajni;
	
	@ManyToOne
    @JoinColumn(name = "kursna_lista", referencedColumnName = "kursna_lista_id", nullable=false)
	private KursnaLista kursnaLista;
	
	@ManyToOne
    @JoinColumn(name = "valuta", referencedColumnName = "valuta_id", nullable=false)
	private Valuta valuta;
	
	public KursUValuti() {
		super();
	}

	public KursUValuti(int redniBroj, double kupovni, double srednji, double prodajni, KursnaLista kursnaLista,
			Valuta valuta) {
		super();
		this.redniBroj = redniBroj;
		this.kupovni = kupovni;
		this.srednji = srednji;
		this.prodajni = prodajni;
		this.kursnaLista = kursnaLista;
		this.valuta = valuta;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
}
