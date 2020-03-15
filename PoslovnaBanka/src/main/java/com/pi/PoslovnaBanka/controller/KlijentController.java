package com.pi.PoslovnaBanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.service.KlijentServiceInterface;

@RestController
@RequestMapping("api/klijent")
public class KlijentController {
	
	@Autowired
	KlijentServiceInterface klijentServiceInterface;
	
	@GetMapping
	private Page<Klijent> getAllContacts(@RequestParam("page") int page, @RequestParam("size") int size) {
		return klijentServiceInterface.findAll(page, size);
	}

}
