package com.pi.PoslovnaBanka.dto.xmlDTOs;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Uplatnica {

	public Duznik duznik;


	public String svrha_placanja;


	public Primalac primalac;


	public Uplata uplata;



	public static Uplatnica loadFromDom(Node uplatnicaNode){
		Element uplatnicaElement = (Element) uplatnicaNode;
		Node duznikNode = uplatnicaElement.getElementsByTagName("duznik").item(0);
		Node svrhaUplateNode = uplatnicaElement.getElementsByTagName("svrha_placanja").item(0);
		Node primalacNode = uplatnicaElement.getElementsByTagName("primalac").item(0);
		Node uplataNode = uplatnicaElement.getElementsByTagName("uplata").item(0);
		
		Uplatnica rez = new Uplatnica();
		rez.setDuznik(Duznik.loadFromDom(duznikNode));
		rez.setSvrha_placanja(svrhaUplateNode.getTextContent());
		rez.setPrimalac(Primalac.loadFromDom(primalacNode));
		rez.setUplata(Uplata.loadFromDom(uplataNode));
		return rez;
	}
	


	public Node generateDom(Document doc) {
		Element uplatnica = doc.createElement("uplatnica");
		uplatnica.appendChild(this.getDuznik().generateDom(doc));

		Element svrha_placanja = doc.createElement("svrha_placanja");
		svrha_placanja.setTextContent(this.getSvrha_placanja());
		uplatnica.appendChild(svrha_placanja);
		
		uplatnica.appendChild(this.getPrimalac().generateDom(doc));	
		uplatnica.appendChild(this.getUplata().generateDom(doc));			
		
		return uplatnica;
	}
	
	public Duznik getDuznik() {
		return duznik;
	}


	public void setDuznik(Duznik duznik) {
		this.duznik = duznik;
	}


	public String getSvrha_placanja() {
		return svrha_placanja;
	}


	public void setSvrha_placanja(String svrha_placanja) {
		this.svrha_placanja = svrha_placanja;
	}


	public Primalac getPrimalac() {
		return primalac;
	}


	public void setPrimalac(Primalac primalac) {
		this.primalac = primalac;
	}


	public Uplata getUplata() {
		return uplata;
	}


	public void setUplata(Uplata uplata) {
		this.uplata = uplata;
	}

	

	public Uplatnica() {
		super();
	}


	public Uplatnica(Duznik duznik, String svrha_placanja, Primalac primalac, Uplata uplata) {
		super();
		this.duznik = duznik;
		this.svrha_placanja = svrha_placanja;
		this.primalac = primalac;
		this.uplata = uplata;
	}
	
}
