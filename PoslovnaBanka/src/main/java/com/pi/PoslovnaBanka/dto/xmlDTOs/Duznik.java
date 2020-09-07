package com.pi.PoslovnaBanka.dto.xmlDTOs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Duznik {
	public Duznik() {
		super();
	}
	public String naziv;
	
	public Adresa adresa;
	
	public String type;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Duznik(String naziv, String type, Adresa adresa) {
		super();
		this.naziv = naziv;
		this.type = type;
		this.adresa = adresa;
	}

	public static Duznik loadFromDom(Node liceNode){
		Element liceElement = (Element) liceNode; 
		String type = liceElement.getAttribute("type");

		String naziv = liceElement.getElementsByTagName("naziv").item(0)
				.getTextContent();
		
		Element adresaElement = (Element)liceElement.getElementsByTagName("adresa").item(0);
		
		Adresa adresa = Adresa.loadFromDom(adresaElement);
		
		return new Duznik(type, naziv, adresa);
	}


	public Node generateDom(Document doc) {
		Element duznik = doc.createElement("duznik");
		duznik.setAttribute("type", this.getType());
		
		Element naziv = doc.createElement("naziv");
		naziv.setTextContent(this.getNaziv());
		duznik.appendChild(naziv);
		
		duznik.appendChild(adresa.generateDom(doc));		
		
		return duznik;
	}
}
