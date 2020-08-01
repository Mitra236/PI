package com.pi.PoslovnaBanka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.service.RacunPravnogLicaServiceInterface;

@RestController
@RequestMapping("api/racuni")
@CrossOrigin(origins = "*")
public class RacunController {
	
	@Autowired
	RacunPravnogLicaServiceInterface racunPravnogLicaServiceInterface;
	
	@GetMapping
	private ResponseEntity<List<RacunPravnogLicaDTO>> getAccounts() {
		List<RacunPravnogLicaDTO> racunPravnogLicaDTOs = new ArrayList<RacunPravnogLicaDTO>();
		List<RacunPravnogLica> racunPravnogLica = racunPravnogLicaServiceInterface.findAll();
		for (RacunPravnogLica r: racunPravnogLica) {
			racunPravnogLicaDTOs.add(new RacunPravnogLicaDTO(r));
		}
		return new ResponseEntity<>(racunPravnogLicaDTOs, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/racun")
	private ResponseEntity<RacunPravnogLicaDTO> getAccount(@RequestParam("id") int id) {
		RacunPravnogLica racunPravnogLica = racunPravnogLicaServiceInterface.findOne(id);
		if (racunPravnogLica == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new RacunPravnogLicaDTO(racunPravnogLica), HttpStatus.OK);
	}
	
	@GetMapping(value="/client")
	private ResponseEntity<RacunPravnogLicaDTO> getAccountClient(@RequestParam("client") int client) {
		RacunPravnogLica racunPravnogLica = racunPravnogLicaServiceInterface.getAccountByUser(client);
		if (racunPravnogLica == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new RacunPravnogLicaDTO(racunPravnogLica), HttpStatus.OK);
	}

}
