package com.pi.PoslovnaBanka.service;

import com.pi.PoslovnaBanka.dto.xmlDTOs.Uplatnice;

public interface XmlServiceInterface {
	Uplatnice UcitajNalogZaPlacanje(String xml);
	String SerijalizujMedjubankarskiPrenos(Uplatnice uplatnice);
}
