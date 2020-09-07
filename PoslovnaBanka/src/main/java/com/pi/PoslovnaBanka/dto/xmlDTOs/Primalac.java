package com.pi.PoslovnaBanka.dto.xmlDTOs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Primalac {
	public Primalac() {
		super();
	}
	public String type;
	
	public String naziv;
	
	public Adresa adresa;

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

	
	
	public Primalac(String type, String naziv, Adresa adresa) {
		super();
		this.type = type;
		this.naziv = naziv;
		this.adresa = adresa;
	}

	public static Primalac loadFromDom(Node liceNode){
		Element liceElement = (Element) liceNode; 
		String type = liceElement.getAttribute("type");

		String naziv = liceElement.getElementsByTagName("naziv").item(0)
				.getTextContent();
		
		Element adresaElement = (Element)liceElement.getElementsByTagName("adresa").item(0);
		
		Adresa adresa = Adresa.loadFromDom(adresaElement);
		
		return new Primalac(type, naziv, adresa);
	}
	

	public Node generateDom(Document doc) {
		Element primalac = doc.createElement("primalac");
		primalac.setAttribute("type", this.getType());
		
		Element naziv = doc.createElement("naziv");
		naziv.setTextContent(this.getNaziv());
		primalac.appendChild(naziv);
		
		primalac.appendChild(adresa.generateDom(doc));		
		
		return primalac;
	}
}
