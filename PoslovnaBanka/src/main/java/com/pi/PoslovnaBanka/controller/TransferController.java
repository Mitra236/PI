package com.pi.PoslovnaBanka.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.TransakcijaDTO;
import com.pi.PoslovnaBanka.service.TransakcijaServiceInterface;
import com.sun.xml.fastinfoset.sax.Properties;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("api/transfer")
@CrossOrigin(origins = "*")
public class TransferController {

	@Autowired
	TransakcijaServiceInterface transakcijaServiceInterface;
	
	@PostMapping(consumes="application/json")
	private ResponseEntity<TransakcijaDTO> saveTransaction(@RequestBody TransakcijaDTO transakcijaDTO) {
		if(transakcijaDTO == null) {
			return new ResponseEntity<TransakcijaDTO>(HttpStatus.NO_CONTENT);
		}
		
		transakcijaServiceInterface.save(transakcijaDTO);
		return new ResponseEntity<TransakcijaDTO>(HttpStatus.OK);
	}
	


}
