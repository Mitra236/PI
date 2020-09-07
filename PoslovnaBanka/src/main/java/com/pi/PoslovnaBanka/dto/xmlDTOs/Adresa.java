package com.pi.PoslovnaBanka.dto.xmlDTOs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Adresa {
	public Adresa() {
		super();
	}
	public String ulica;
	public String broj;
	public Mesto mesto;
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public Mesto getMesto() {
		return mesto;
	}
	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}
	public Adresa(String ulica, String broj, Mesto mesto) {
		super();
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = mesto;
	}
	

	
	public static Adresa loadFromDom(Node adresaNode){
		Element adresaElement = (Element) adresaNode;
		String ulica = adresaElement.getElementsByTagName("ulica").item(0).getTextContent();
		String broj = adresaElement.getElementsByTagName("broj").item(0).getTextContent();
		Element mestoElement = (Element) adresaElement.getElementsByTagName("mesto").item(0);		
		Mesto mesto = Mesto.loadFromDom(mestoElement);
		return new Adresa(ulica, broj, mesto);
	}

	public Node generateDom(Document doc) {
		Element adresa = doc.createElement("adresa");
		adresa.setAttribute("ulica", this.getUlica());
		
		Element ulica = doc.createElement("ulica");
		ulica.setTextContent(this.getUlica());
		adresa.appendChild(ulica);

		Element broj = doc.createElement("broj");
		broj.setTextContent(this.getBroj());
		adresa.appendChild(broj);
		
		adresa.appendChild(mesto.generateDom(doc));
		return adresa;
	}
}
