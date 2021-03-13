package com.pi.PoslovnaBanka.controller;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	
	@PostMapping(value="/xml", consumes="text/xml")
	private ResponseEntity<?> saveTransactionFromXml(@RequestBody TransakcijaDTO transakcijaDTO) {
		if(transakcijaDTO == null) {
			return new ResponseEntity<TransakcijaDTO>(HttpStatus.NO_CONTENT);
		}
		
		try {
			transakcijaServiceInterface.save(transakcijaDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Transakcija je uspesno sacuvana!", HttpStatus.OK);
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
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	
	@GetMapping(value="/by-date")
	private ResponseEntity<List<TransakcijaDTO>> getTransactionByAccountNumberAndDate(@RequestParam("brojRacuna") String brojRacuna, @RequestParam("od_datuma") java.sql.Date odDatuma, @RequestParam("do_datuma") java.sql.Date doDatuma) {
		List<TransakcijaDTO> transakcijaDTOs = transakcijaServiceInterface.getTransactionByAccountNumberAndTimeRange(brojRacuna, odDatuma, doDatuma);
		if (transakcijaDTOs == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(transakcijaDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="/by-account-number")
	private ResponseEntity<List<TransakcijaDTO>> getTransactionByAccountNumber(@RequestParam("brojRacuna") String brojRacuna) {
		List<TransakcijaDTO> transakcijaDTOs = transakcijaServiceInterface.getTransactionByAccountNumber(brojRacuna);
		if (transakcijaDTOs == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(transakcijaDTOs, HttpStatus.OK);
	}
}
