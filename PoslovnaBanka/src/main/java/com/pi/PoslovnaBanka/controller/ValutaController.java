package com.pi.PoslovnaBanka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.ValutaDTO;
import com.pi.PoslovnaBanka.service.ValutaServiceInterface;

@RestController
@RequestMapping("api/valuta")
@CrossOrigin(origins = "*")
public class ValutaController {
	
	@Autowired
	ValutaServiceInterface valutaServiceInterface;
	
	@GetMapping()
	private ResponseEntity<List<ValutaDTO>> getValute() {
		List<ValutaDTO> valutaDTOs = valutaServiceInterface.findAll();
		if(valutaDTOs == null) {
			return new ResponseEntity<List<ValutaDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ValutaDTO>>(valutaDTOs, HttpStatus.OK);
	}

}
