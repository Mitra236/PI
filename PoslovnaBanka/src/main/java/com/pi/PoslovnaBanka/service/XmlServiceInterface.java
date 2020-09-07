package com.pi.PoslovnaBanka.service;

import java.io.File;
import java.util.List;

import com.pi.PoslovnaBanka.dto.xmlDTOs.Uplatnice;

public interface XmlServiceInterface {
	Uplatnice UcitajNalogZaPlacanje(String xml);
	String SerijalizujMedjubankarskiPrenos(Uplatnice uplatnice);
}
