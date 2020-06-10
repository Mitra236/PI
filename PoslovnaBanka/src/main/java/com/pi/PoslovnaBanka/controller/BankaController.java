package com.pi.PoslovnaBanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.BankaPoNazivuDTO;
import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.service.BankaServiceInterface;

@RestController
@RequestMapping("api/banka")
public class BankaController {
	
	@Autowired
	BankaServiceInterface bankaServiceInterface;
	
	@GetMapping
	private ResponseEntity<BankaPoNazivuDTO> getBankaPoNazivu(@RequestParam("naziv") String naziv) {
		Banka banka = bankaServiceInterface.getBankByName(naziv);
		if (banka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new BankaPoNazivuDTO(banka), HttpStatus.OK);
	}

}
