package com.pi.PoslovnaBanka.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.service.ReportsServiceInterface;

@RestController
@RequestMapping("api/reports")
@CrossOrigin(origins = "*")
public class ReportsController {
	
	@Autowired
	ReportsServiceInterface reports;
	
	@GetMapping
	public ResponseEntity<InputStreamResource> getReport(String racun, Date od_datuma, Date do_datuma) throws Throwable, IOException, SQLException{
		
		ByteArrayInputStream bis = reports.getReports(racun, od_datuma, do_datuma);
		System.out.println(bis);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=time_range_report.pdf");

		return ResponseEntity
	       		.ok()
	       		.headers(headers)
	       		.contentType(MediaType.APPLICATION_PDF)
	       		.body(new InputStreamResource(bis));
	}
	
	@GetMapping("/bank-report")
	public ResponseEntity<InputStreamResource> getBankReport() throws Throwable, IOException, SQLException{
		
		ByteArrayInputStream bis = reports.getBankReports();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=bank_report.pdf");

		return ResponseEntity
	       		.ok()
	       		.headers(headers)
	       		.contentType(MediaType.APPLICATION_PDF)
	       		.body(new InputStreamResource(bis));
	}
}
