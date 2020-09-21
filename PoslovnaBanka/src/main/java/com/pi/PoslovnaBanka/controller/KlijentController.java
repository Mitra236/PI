package com.pi.PoslovnaBanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.KlijentDTO;
import com.pi.PoslovnaBanka.service.KlijentServiceInterface;

@RestController
@RequestMapping("api/klijenti")
@CrossOrigin(origins = "*")
public class KlijentController {
	
	@Autowired
	KlijentServiceInterface klijentServiceInterface;
	
//	@GetMapping
//	private ResponseEntity<List<KlijentDTO>> getAllContacts() {
//		List<KlijentDTO> klijentDTO = klijentServiceInterface.findAll();
//		if(klijentDTO == null) {
//			return new ResponseEntity<List<KlijentDTO>>(HttpStatus.NO_CONTENT);
//		}	
//
//		return new ResponseEntity<>(klijentDTO, HttpStatus.OK);
//	}
	
	@GetMapping(value = "/page")
	private Page<KlijentDTO> getAllContacts(@RequestParam("page") int page, @RequestParam("size") int size) {
		return klijentServiceInterface.findAll(page, size);
	}
	
	@GetMapping(value="/klijent")
	private ResponseEntity<KlijentDTO> getClient(@RequestParam("id") int id) {
		KlijentDTO klijent = klijentServiceInterface.findOne(id);
		if (klijent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(klijent, HttpStatus.OK);
	}

}
