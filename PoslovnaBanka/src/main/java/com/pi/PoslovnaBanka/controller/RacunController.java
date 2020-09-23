package com.pi.PoslovnaBanka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.DnevnoStanjeDTO;
import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;
import com.pi.PoslovnaBanka.service.DnevnoStanjeRacunaServiceInterface;
import com.pi.PoslovnaBanka.service.RacunPravnogLicaServiceInterface;

@RestController
@RequestMapping("api/racuni")
@CrossOrigin(origins = "*")
public class RacunController {
	
	@Autowired
	RacunPravnogLicaServiceInterface racunPravnogLicaServiceInterface;
	
	@Autowired
	DnevnoStanjeRacunaServiceInterface dnevnoStanjeRacunaInterface;
	
	@GetMapping
	private ResponseEntity<List<RacunPravnogLicaDTO>> getAccounts() {
		List<RacunPravnogLicaDTO> racunPravnogLicaDTOs = racunPravnogLicaServiceInterface.findAll();
		if(racunPravnogLicaDTOs == null) {
			return new ResponseEntity<List<RacunPravnogLicaDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(racunPravnogLicaServiceInterface.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/racun")
	private ResponseEntity<RacunPravnogLicaDTO> getAccount(@RequestParam("id") int id) {
		RacunPravnogLicaDTO racunPravnogLica = racunPravnogLicaServiceInterface.findOne(id);
		if (racunPravnogLica == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(racunPravnogLica, HttpStatus.OK);
	}
	
	@GetMapping(value="/client")
	private ResponseEntity<RacunPravnogLicaDTO> getAccountClient(@RequestParam("client") int client) {
		RacunPravnogLicaDTO racunPravnogLica = racunPravnogLicaServiceInterface.getAccountByUser(client);
		if (racunPravnogLica == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(racunPravnogLica, HttpStatus.OK);
	}
	
	@GetMapping(value="/dnevno-stanje")
	private ResponseEntity<DnevnoStanjeDTO> getDailyReportByUser(@RequestParam("id") int id) {
		System.out.println(id);
		DnevnoStanjeDTO dnevnoStanjeDTO = dnevnoStanjeRacunaInterface.getStateByUser(id);
		if (dnevnoStanjeDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<DnevnoStanjeDTO>(dnevnoStanjeDTO, HttpStatus.OK);
	}

	@GetMapping(value="/client-and-number")
	private ResponseEntity<RacunPravnogLicaDTO> getAccountByClientAndNumber(@RequestParam("id") int id, @RequestParam("number") String number) {
		RacunPravnogLicaDTO racunPravnogLica = racunPravnogLicaServiceInterface.getAccountByUserAndAccountNumber(id, number);
		if (racunPravnogLica == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(racunPravnogLica, HttpStatus.OK);
	}
}
