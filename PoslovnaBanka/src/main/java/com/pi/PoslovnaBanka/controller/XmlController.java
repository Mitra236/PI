package com.pi.PoslovnaBanka.controller;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pi.PoslovnaBanka.dto.BankaPoNazivuDTO;
import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;
import com.pi.PoslovnaBanka.dto.xmlDTOs.Uplatnica;
import com.pi.PoslovnaBanka.dto.xmlDTOs.Uplatnice;
import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.service.BankaServiceInterface;
import com.pi.PoslovnaBanka.service.XmlServiceInterface;


@RestController
@RequestMapping("api/xml")
@CrossOrigin(origins = "*")
public class XmlController {
	
	@Autowired
	XmlServiceInterface xmlService;
	
	@PostMapping(value = "/submit", consumes = "application/xml")
	@Transactional
	public ResponseEntity<Uplatnice> submitXml(@RequestParam("file") MultipartFile file) {
		try {
			String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
			
			Uplatnice upl = xmlService.UcitajNalogZaPlacanje(fileContent);
			if(upl == null)
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
			
			return new ResponseEntity<Uplatnice>(upl, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	

	@GetMapping(value = "/read", produces = "application/xml")
	@Transactional
	public String getXml() {
		try {
			Uplatnice uplatnice = new Uplatnice();

			String upl = xmlService.SerijalizujMedjubankarskiPrenos(uplatnice);
			if(upl == null)
				return null;
				
			return upl;
		} catch(Exception e) {
			return null;
		}
			
	}
	

	@GetMapping(value = "/getXmlFile")
	@Transactional
	public ResponseEntity<Resource> getXmlFile() {
		try {
			Uplatnice uplatnice = new Uplatnice();
			
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
