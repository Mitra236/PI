package com.pi.PoslovnaBanka.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
//	@Transactional
//	@PostMapping()
//	private ResponseEntity<TransakcijaDTO> saveTransaction(@RequestBody TransakcijaDTO transakcijaDTO) {
//		Transakcija transakcija = new Transakcija();
//		
//		transakcija.setDatumPrijema(Date.valueOf(LocalDate.now()));
//		transakcija.setDuznik(transakcijaDTO.getDuznik());
//		transakcija.setDatumValute(Date.valueOf(LocalDate.now()));
//	//	transakcija.s
//	}
}
