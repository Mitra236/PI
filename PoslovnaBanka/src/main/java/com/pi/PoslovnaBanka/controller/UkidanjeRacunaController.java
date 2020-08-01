package com.pi.PoslovnaBanka.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.service.RacunPravnogLicaServiceInterface;

@RestController
@RequestMapping("api/ukidanje")
@CrossOrigin(origins = "*")
public class UkidanjeRacunaController {

	@Autowired
	RacunPravnogLicaServiceInterface racunPravnogLicaServiceInterface;
	
	@PostMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	@Transactional
	public ResponseEntity<RacunPravnogLicaDTO> deleteAccount(@RequestBody String racunPravnogLicaDTO, @PathVariable("id") int id) {
		RacunPravnogLica racunPravnogLica = racunPravnogLicaServiceInterface.findOne(id);
		if (racunPravnogLica == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		racunPravnogLica.setVazeci(false);
		racunPravnogLica.getUkidanje().setDatumUkidanja(Date.valueOf(LocalDate.now()));
		racunPravnogLica.getUkidanje().setSredstvaSePrenoseNaRacun(racunPravnogLicaDTO);
		
		racunPravnogLicaServiceInterface.save(racunPravnogLica);
		
		return new ResponseEntity<>(new RacunPravnogLicaDTO(racunPravnogLica), HttpStatus.OK);
		
	}
}
