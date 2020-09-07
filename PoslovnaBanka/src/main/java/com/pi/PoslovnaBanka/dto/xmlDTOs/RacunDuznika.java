package com.pi.PoslovnaBanka.dto.xmlDTOs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
public class RacunDuznika {
	public RacunDuznika() {
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

	public RacunDuznika(String racun, String model, String poziv_na_broj) {
		super();
		this.racun = racun;
		this.model = model;
		this.poziv_na_broj = poziv_na_broj;
	}
	
	public static RacunDuznika loadFromDom(Node racunNode){
		Element racunElement = (Element) racunNode;
		String brojRacuna = racunElement.getElementsByTagName("racun").item(0).getTextContent();
		String model = racunElement.getElementsByTagName("model").item(0).getTextContent();
		String pozivNaBroj = racunElement.getElementsByTagName("poziv_na_broj").item(0).getTextContent();
		return new RacunDuznika(brojRacuna, model, pozivNaBroj);
	}
	


	public Node generateDom(Document doc) {
		Element racun_duznika = doc.createElement("racun_duznika");

		Element racun = doc.createElement("racun");
		racun.setTextContent(this.getRacun());
		racun_duznika.appendChild(racun);	
		

		Element model = doc.createElement("model");
		model.setTextContent(this.getModel());
		racun_duznika.appendChild(model);
		

		Element poziv_na_broj = doc.createElement("poziv_na_broj");
		poziv_na_broj.setTextContent(this.getPoziv_na_broj());
		racun_duznika.appendChild(poziv_na_broj);
		
		return racun_duznika;
	}
}
