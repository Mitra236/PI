package com.pi.PoslovnaBanka.dto.xmlDTOs;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Uplata {
	public Uplata() {
		super();
	}
	public String sifra_placanja;
	
	public Double iznos;
	
	public String valuta;
	
	public RacunPrimaoca racun_primaoca;
	
	public RacunDuznika racun_duznika;

	public String getSifra_placanja() {
		return sifra_placanja;
	}

	public void setSifra_placanja(String sifra_placanja) {
		this.sifra_placanja = sifra_placanja;
	}

	public Double getIznos() {
		return iznos;
	}

	public void setIznos(Double iznos) {
		this.iznos = iznos;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public RacunPrimaoca getRacun_primaoca() {
		return racun_primaoca;
	}

	public void setRacun_primaoca(RacunPrimaoca racun_primaoca) {
		this.racun_primaoca = racun_primaoca;
	}

	public RacunDuznika getRacun_duznika() {
		return racun_duznika;
	}

	public void setRacun_duznika(RacunDuznika racun_duznika) {
		this.racun_duznika = racun_duznika;
	}

	public Uplata(String sifra_placanja, Double iznos, String valuta, RacunPrimaoca racun_primaoca,
			RacunDuznika racun_duznika) {
		super();
		this.sifra_placanja = sifra_placanja;
		this.iznos = iznos;
		this.valuta = valuta;
		this.racun_primaoca = racun_primaoca;
		this.racun_duznika = racun_duznika;
	}
	

	public static Uplata loadFromDom(Node uplataNode){
		Element uplataElement = (Element) uplataNode;
		String sifraPlacanja = uplataElement.getElementsByTagName("sifra_placanja").item(0).getTextContent();
		String iznos = uplataElement.getElementsByTagName("iznos").item(0).getTextContent();
		String valuta = uplataElement.getElementsByTagName("valuta").item(0).getTextContent();

		RacunDuznika racunDuznika = RacunDuznika.loadFromDom(uplataElement.getElementsByTagName("racun_duznika").item(0));
		RacunPrimaoca racunPrimaoca = RacunPrimaoca.loadFromDom(uplataElement.getElementsByTagName("racun_primaoca").item(0));

		return new Uplata(sifraPlacanja, Double.parseDouble(iznos), valuta, racunPrimaoca, racunDuznika);
	}


	public Node generateDom(Document doc) {
		Element uplata = doc.createElement("uplata");

		Element sifra_placanja = doc.createElement("sifra_placanja");
		sifra_placanja.setTextContent(this.getSifra_placanja());
		uplata.appendChild(sifra_placanja);

		Element iznos = doc.createElement("iznos");
		iznos.setTextContent(this.getIznos().toString());
		uplata.appendChild(iznos);

		Element valuta = doc.createElement("valuta");
		valuta.setTextContent(this.getValuta());
		uplata.appendChild(valuta);
		
		uplata.appendChild(this.getRacun_duznika().generateDom(doc));	
		uplata.appendChild(this.getRacun_primaoca().generateDom(doc));			
		
		return uplata;
	}
}
