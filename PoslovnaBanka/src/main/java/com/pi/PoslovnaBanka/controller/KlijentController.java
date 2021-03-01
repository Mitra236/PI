package com.pi.PoslovnaBanka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.PoslovnaBanka.dto.BankaDTO;
import com.pi.PoslovnaBanka.dto.KlijentDTO;
import com.pi.PoslovnaBanka.dto.RacunPravnogLicaDTO;
import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.entity.KursnaLista;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.service.KlijentServiceInterface;
import com.pi.PoslovnaBanka.service.RacunPravnogLicaServiceInterface;

@RestController
@RequestMapping("api/klijenti")
@CrossOrigin(origins = "*")
public class KlijentController {
	
	@Autowired
	KlijentServiceInterface klijentServiceInterface;
	
	@Autowired
	RacunPravnogLicaServiceInterface racunPravnogLicaServiceInterface;
	
	@GetMapping(value="/sviKlijenti")
	private ResponseEntity<List<KlijentDTO>> getKlijenti() {
		List<Klijent> klijenti = klijentServiceInterface.findAllVazece();
		if (klijenti == null ) {
			return new ResponseEntity<List<KlijentDTO>>(HttpStatus.NOT_FOUND);
		}
		List<KlijentDTO> klDTO = new ArrayList<>();
		for(Klijent k : klijenti) {
			klDTO.add(new KlijentDTO(k));
		}
		return new ResponseEntity<List<KlijentDTO>>(klDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/page")
	private Page<KlijentDTO> getAllContacts(@RequestParam("page") int page, @RequestParam("size") int size) {
		return klijentServiceInterface.findAll(page, size);
	}
	
	@GetMapping(value="/klijent")
	private ResponseEntity<KlijentDTO> getClient(@RequestParam("id") int id) {
		KlijentDTO klijent = klijentServiceInterface.findOne(id);
		if (klijent == null || klijent.isVazeci() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(klijent, HttpStatus.OK);
	}

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable("id") Integer id){		

		KlijentDTO klijent = klijentServiceInterface.findOne(id);
		if(id == null || klijent.isVazeci() == false) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		klijentServiceInterface.remove(klijent);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<KlijentDTO> saveClient(@RequestBody KlijentDTO klijentDTO){
		try {
			if (klijentDTO == null) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			KlijentDTO kl = klijentServiceInterface.findOne(klijentDTO.getId());
			if (kl != null) {
				return new ResponseEntity<KlijentDTO>(HttpStatus.BAD_REQUEST);
			}

			klijentDTO.setId(0);
			
			int id = klijentServiceInterface.save(klijentDTO);
			klijentDTO.setId(id);
			return new ResponseEntity<KlijentDTO>(klijentDTO, HttpStatus.OK);	
		} 
		catch(Exception e) {
			return new ResponseEntity<KlijentDTO>(new KlijentDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<KlijentDTO> updateClient(@RequestBody KlijentDTO klijentDTO, @PathVariable("id") Integer id){
		KlijentDTO kl = klijentServiceInterface.findOne(id);
		if (kl == null) {
			return new ResponseEntity<KlijentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		kl.setIme(klijentDTO.getIme());
		kl.setPrezime(klijentDTO.getPrezime());
		kl.setAdresa(klijentDTO.getAdresa());
		kl.setEmail(klijentDTO.getEmail());
		kl.setTelefon(klijentDTO.getTelefon());
		kl.setJMBG(klijentDTO.getJMBG());
		kl.setUloga(klijentDTO.getUloga());
		kl.setVazeci(klijentDTO.isVazeci());
		klijentServiceInterface.save(kl);
		return new ResponseEntity<KlijentDTO>(kl, HttpStatus.OK);
		
	}
}
