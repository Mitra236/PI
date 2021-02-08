package com.pi.PoslovnaBanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.TransakcijaDTO;
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
}
