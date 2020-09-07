package com.pi.PoslovnaBanka.service;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.dto.xmlDTOs.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class XmlService implements XmlServiceInterface {

	@Override
	public Uplatnice UcitajNalogZaPlacanje(String xml) {
		Uplatnice uplatnice = null;
		try {
			DocumentBuilderFactory docBuilder = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = docBuilder.newDocumentBuilder();
	        Document doc = builder.parse(xml);

	        uplatnice = Uplatnice.loadFromDom(doc.getElementsByTagName("uplatnice").item(0));
		} catch(Exception e) {
			
		}
		
		return uplatnice;
	}

	@Override
	public String SerijalizujMedjubankarskiPrenos(Uplatnice uplatnice) {
		String xml = null;
		try {
			DocumentBuilderFactory docBuilder = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = docBuilder.newDocumentBuilder();
	        Document doc = builder.newDocument();

	        Element uplatniceDom = (Element) uplatnice.generateDom(doc);
	        
	        doc.appendChild(uplatniceDom);
	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transf = transformerFactory.newTransformer();
	        
	        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transf.setOutputProperty(OutputKeys.INDENT, "yes");
	        transf.setOutputProperty(OutputKeys.VERSION, "1.0");
	        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        
	        DOMSource source = new DOMSource(doc);
	        StringWriter writer = new StringWriter();
	        StreamResult file = new StreamResult(writer);
	        transf.transform(source, file);
	        
	        xml = writer.toString();
		} catch(Exception e) {
			xml = null;
		}
		
		
		return xml;
	}
	
}
