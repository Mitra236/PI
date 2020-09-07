package com.pi.PoslovnaBanka.dto.xmlDTOs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RacunPrimaoca {
	public RacunPrimaoca() {
		super();
	}
	public String racun;
	
	public String model;
	
	public String poziv_na_broj;

	public String getRacun() {
		return racun;
	}

	public void setRacun(String racun) {
		this.racun = racun;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPoziv_na_broj() {
		return poziv_na_broj;
	}

	public void setPoziv_na_broj(String poziv_na_broj) {
		this.poziv_na_broj = poziv_na_broj;
	}

	public RacunPrimaoca(String racun, String model, String poziv_na_broj) {
		super();
		this.racun = racun;
		this.model = model;
		this.poziv_na_broj = poziv_na_broj;
	}

	public static RacunPrimaoca loadFromDom(Node racunNode){
		Element racunElement = (Element) racunNode;
		String brojRacuna = racunElement.getElementsByTagName("racun").item(0).getTextContent();
		String model = racunElement.getElementsByTagName("model").item(0).getTextContent();
		String pozivNaBroj = racunElement.getElementsByTagName("poziv_na_broj").item(0).getTextContent();
		return new RacunPrimaoca(brojRacuna, model, pozivNaBroj);
	}
	


	public Node generateDom(Document doc) {
		Element racun_primaoca = doc.createElement("racun_primaoca");

		Element racun = doc.createElement("racun");
		racun.setTextContent(this.getRacun());
		racun_primaoca.appendChild(racun);	
		

		Element model = doc.createElement("model");
		model.setTextContent(this.getModel());
		racun_primaoca.appendChild(model);
		

		Element poziv_na_broj = doc.createElement("poziv_na_broj");
		poziv_na_broj.setTextContent(this.getPoziv_na_broj());
		racun_primaoca.appendChild(poziv_na_broj);
		
		return racun_primaoca;
	}
}
