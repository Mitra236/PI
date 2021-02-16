package com.pi.PoslovnaBanka.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.TransakcijaDTO;
import com.pi.PoslovnaBanka.dto.xmlDTOs.Duznik;
import com.pi.PoslovnaBanka.dto.xmlDTOs.Primalac;
import com.pi.PoslovnaBanka.dto.xmlDTOs.RacunDuznika;
import com.pi.PoslovnaBanka.dto.xmlDTOs.RacunPrimaoca;
import com.pi.PoslovnaBanka.dto.xmlDTOs.Uplata;
import com.pi.PoslovnaBanka.dto.xmlDTOs.Uplatnica;
import com.pi.PoslovnaBanka.dto.xmlDTOs.Uplatnice;
import com.pi.PoslovnaBanka.entity.Transakcija;
import com.pi.PoslovnaBanka.service.TransakcijaServiceInterface;
import com.pi.PoslovnaBanka.service.XmlServiceInterface;


@RestController
@RequestMapping("api/xml")
@CrossOrigin(origins = "*")
public class XmlController {
	
	@Autowired
	XmlServiceInterface xmlService;

	@Autowired
	TransakcijaServiceInterface transakcijaServiceInterface;
	
	public XmlController() {
		super();
	}

	//@Transactional
	@RequestMapping(value = "/submit", method=RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<Uplatnice> submitXml(@RequestBody Uplatnica somereq) {
		try {
			String fileContent = "";
			
			Uplatnice upl = xmlService.UcitajNalogZaPlacanje(fileContent);
			if(upl == null)
				return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
				
			List<Uplatnica> uplatnice = upl.getUplatnice();
			
			for(Uplatnica u : uplatnice) {
				TransakcijaDTO t = new TransakcijaDTO();
				t.setDuznik(u.getDuznik().getNaziv());
				t.setPoverilac(u.getPrimalac().getNaziv());
				t.setIznos(u.getUplata().getIznos());
				t.setRacunDuznika(u.getUplata().getRacun_duznika().getRacun());
				t.setRacunPoverioca(u.getUplata().getRacun_primaoca().getRacun());
				t.setModelOdobrenja(Integer.parseInt(u.getUplata().getRacun_primaoca().getModel()));
				t.setModelZaduzenja(Integer.parseInt(u.getUplata().getRacun_duznika().getModel()));
				
				transakcijaServiceInterface.save(t);
			}
			
			return new ResponseEntity<Uplatnice>(upl, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	

//	@GetMapping(value = "/read", produces = "application/xml")
//	@Transactional
//	public String getXml() {
//		try {
//			Uplatnice uplatnice = new Uplatnice();
//
//			String upl = xmlService.SerijalizujMedjubankarskiPrenos(uplatnice);
//			if(upl == null)
//				return null;
//				
//			return upl;
//		} catch(Exception e) {
//			return null;
//		}
//			
//	}
//	

	@GetMapping(value = "/getXmlFile")
	@Transactional
	public ResponseEntity<Resource> getXmlFile() {
		try {
			
			List<Transakcija> transakcije = transakcijaServiceInterface.findAll();
			
			if(transakcije == null)
				transakcije = new ArrayList<Transakcija>();
			
			Uplatnice uplatnice = new Uplatnice();
			
			List<Uplatnica> listaUplatnica = new ArrayList<Uplatnica>();
			
			for(Transakcija t : transakcije) {
				Duznik d = new Duznik();
				d.setNaziv(t.getDuznik());
				
				Primalac p = new Primalac();
				p.setNaziv(t.getPoverilac());
				
				RacunDuznika rd = new RacunDuznika();
				rd.setRacun(t.getRacunDuznika());
				rd.setModel(String.valueOf(t.getModelZaduzenja()));
				
				
				RacunPrimaoca rp = new RacunPrimaoca();
				rp.setRacun(t.getRacunPoverioca());
				rp.setModel(String.valueOf(t.getModelZaduzenja()));
				
				
				Uplata u = new Uplata();
				u.setIznos(t.getIznos());
				u.setRacun_duznika(rd);
				u.setRacun_primaoca(rp);
				u.setSifra_placanja(t.getVrstaPlacanja().getOznakaVrste());
								
				Uplatnica upl = new Uplatnica(d, t.getSvrhaPlacanja(), p, u);
				listaUplatnica.add(upl);
			}
			

			uplatnice.setUplatnice(listaUplatnica);
			
			String upl = xmlService.SerijalizujMedjubankarskiPrenos(uplatnice);
			
			if(upl == null)
				upl = "";

		    ByteArrayResource resource = new ByteArrayResource(upl.getBytes());
		    
		    HttpHeaders headers = new HttpHeaders();
	        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        headers.add("Pragma", "no-cache");
	        headers.add("Expires", "0");
		    return ResponseEntity.ok()
		            .headers(headers)
		            .contentLength(upl.getBytes().length)
		            .contentType(MediaType.APPLICATION_XML)
		            .body(resource);
		} catch(Exception e) {
		    return ResponseEntity.badRequest()
		    		.body(new ByteArrayResource(null));
		}
			
	}
}
