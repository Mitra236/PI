package com.pi.PoslovnaBanka.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.service.KlijentServiceInterface;

@RestController
@RequestMapping("api/klijenti")
@CrossOrigin(origins = "*")
public class KlijentController {
	
	@Autowired
	KlijentServiceInterface klijentServiceInterface;
	
	
	@GetMapping
	private ResponseEntity<List<KlijentDTO>> getAllContacts() {
		List<KlijentDTO> klijentDTO = new ArrayList<KlijentDTO>();
		for(Klijent k: klijentServiceInterface.findAll()) {
			klijentDTO.add(new KlijentDTO(k));
		}

		return new ResponseEntity<>(klijentDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/page")
	private Page<Klijent> getAllContacts(@RequestParam("page") int page, @RequestParam("size") int size) {
		return klijentServiceInterface.findAll(page, size);
	}
	
	@GetMapping(value="/klijent")
	private ResponseEntity<KlijentDTO> getClient(@RequestParam("id") int id) {
		Klijent klijent = klijentServiceInterface.findOne(id);
		if (klijent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new KlijentDTO(klijent), HttpStatus.OK);
	}

}
