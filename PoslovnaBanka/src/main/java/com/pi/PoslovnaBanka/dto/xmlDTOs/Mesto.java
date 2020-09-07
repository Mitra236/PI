package com.pi.PoslovnaBanka.dto.xmlDTOs;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

public class Mesto {
	
	public String naziv;
	public String postanski_broj;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPostanski_broj() {
		return postanski_broj;
	}

	public void setPostanski_broj(String postanski_broj) {
		this.postanski_broj = postanski_broj;
	}
	public Mesto() {
		super();
	}

	public Mesto(String naziv, String postanski_broj) {
		super();
		this.naziv = naziv;
		this.postanski_broj = postanski_broj;
	}

	
	public static Mesto loadFromDom(Node mestoNode){
		Element mestoElement = (Element) mestoNode;
		String naziv = mestoElement.getElementsByTagName("naziv").item(0).getTextContent();
		String postanskiBr = mestoElement.getAttribute("postanski_broj");
		return new Mesto(naziv, postanskiBr);
	}
	
	public Node generateDom(Document doc) {
		Element mesto = doc.createElement("mesto");
		mesto.setAttribute("postanski_broj", this.getPostanski_broj());
		mesto.setTextContent(this.getNaziv());
		return mesto;
	}
	
}
