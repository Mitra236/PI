package com.pi.PoslovnaBanka.dto.xmlDTOs;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Uplatnice {
	public List<Uplatnica> uplatnice;

	public List<Uplatnica> getUplatnice() {
		return uplatnice;
	}
	
	public Uplatnice() {
		super();
	}


	public static Uplatnice loadFromDom(Node uplatniceNode) {
		Element uplatniceElement = (Element) uplatniceNode;
		Uplatnice uplatnice = new Uplatnice();
		NodeList uplatniceNodes = uplatniceElement.getElementsByTagName("uplatnica");
		for(int i=0; i<uplatniceNodes.getLength(); i++){
			Node uplatnicaNode = uplatniceNodes.item(i);
			Uplatnica uplatnica = Uplatnica.loadFromDom(uplatnicaNode);
			uplatnice.uplatnice.add(uplatnica);
		}
		return uplatnice;
	}


	public Node generateDom(Document doc) {
		Element uplatnice = doc.createElementNS("http://www.ftn.uns.ac.rs/uplatnica", "www.ftn.uns.ac.rs");

		for(Uplatnica u : this.getUplatnice()) {
			uplatnice.appendChild(u.generateDom(doc));
		}
		
		return uplatnice;
	}

	public void setUplatnice(List<Uplatnica> uplatnice) {
		this.uplatnice = uplatnice;
	}
}
