package com.pi.PoslovnaBanka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.KlijentDTO;
import com.pi.PoslovnaBanka.dto.TransakcijaDTO;
import com.pi.PoslovnaBanka.entity.Transakcija;
import com.pi.PoslovnaBanka.service.TransakcijaServiceInterface;

@RestController
@RequestMapping("api/transfer")
@CrossOrigin(origins = "*")
public class TransferController {

	@Autowired
	TransakcijaServiceInterface transakcijaServiceInterface;
	
	@PostMapping(consumes="application/json")
	private ResponseEntity<?> saveTransaction(@RequestBody TransakcijaDTO transakcijaDTO) {
		if(transakcijaDTO == null) {
			return new ResponseEntity<TransakcijaDTO>(HttpStatus.NO_CONTENT);
		}
		
		
		try {
			transakcijaServiceInterface.save(transakcijaDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<TransakcijaDTO>(HttpStatus.OK);
	}
	
	@GetMapping()
	private ResponseEntity<List<Integer>> getClientsIds() {
		List<Integer> ids = new ArrayList<Integer>();
		List<Transakcija> transakcije = transakcijaServiceInterface.findAll();
		if (transakcije == null || transakcije.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		for (Transakcija t : transakcije) {
			ids.add(t.getBrojStavke());
		}
		
		return new ResponseEntity<>(ids, HttpStatus.OK);
	}
	
	@GetMapping(value="/xml", produces = MediaType.APPLICATION_XML_VALUE)
	private ResponseEntity<TransakcijaDTO> getClientxml(@RequestParam("id") int id) {
		TransakcijaDTO transakcija = transakcijaServiceInterface.findOne(id);
		if (transakcija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(transakcija, HttpStatus.OK);
	}
}
