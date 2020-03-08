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
@Table(name = "kursneListe")
public class KursnaLista implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kursna_lista_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "datum", unique = false, nullable = false)
	private Date datum;
	
	@Column(name = "broj_kursne_liste", unique = true, nullable = false)
	private int brojKursneListe;
	
	@Column(name = "datum_primene", unique = false, nullable = false)
	private Date primenjujeSeOd;
	
	@ManyToOne
    @JoinColumn(name = "banka", referencedColumnName = "banka_id", nullable=false)
	private Banka banka;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "kursnaLista")
	private Set<KursUValuti> kursUValuti = new HashSet<KursUValuti>();
	
	public KursnaLista() {
		super();
	}

	public KursnaLista(int id, Date datum, int brojKursneListe, Date primenjujeSeOd, Banka banka,
			Set<KursUValuti> kursUValuti) {
		super();
		this.id = id;
		this.datum = datum;
		this.brojKursneListe = brojKursneListe;
		this.primenjujeSeOd = primenjujeSeOd;
		this.banka = banka;
		this.kursUValuti = kursUValuti;
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

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public Set<KursUValuti> getKursUValuti() {
		return kursUValuti;
	}

	public void setKursUValuti(Set<KursUValuti> kursUValuti) {
		this.kursUValuti = kursUValuti;
	}
}
