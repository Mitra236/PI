package com.pi.PoslovnaBanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;
import com.pi.PoslovnaBanka.service.RacunPravnogLicaServiceInterface;
import com.pi.PoslovnaBanka.service.UkidanjeServiceInterface;

@RestController
@RequestMapping("api/ukidanje")
@CrossOrigin(origins = "*")
public class UkidanjeRacunaController {

	@Autowired
	RacunPravnogLicaServiceInterface racunPravnogLicaServiceInterface;
	
	@Autowired
	UkidanjeServiceInterface ukidanjeServiceInterface;
	
	@GetMapping()
	public ResponseEntity<?> deleteAccount(@RequestParam("brojRacuna") String racunPravnogLica, @RequestParam("id") int id) throws Exception {
		RacunPravnogLicaDTO racunPravnogLicaa = racunPravnogLicaServiceInterface.findOne(id);
		if (racunPravnogLicaa == null) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			ukidanjeServiceInterface.save(racunPravnogLica, id);
		} catch (Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);	
	}
}
