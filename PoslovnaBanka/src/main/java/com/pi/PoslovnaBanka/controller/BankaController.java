package com.pi.PoslovnaBanka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.pi.PoslovnaBanka.dto.BankaPoNazivuDTO;
import com.pi.PoslovnaBanka.dto.KursUValutiDTO;
import com.pi.PoslovnaBanka.dto.KursnaListaDTO;
import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.entity.KursUValuti;
import com.pi.PoslovnaBanka.entity.KursnaLista;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.service.BankaServiceInterface;
import com.pi.PoslovnaBanka.service.KursUValutiServiceInterface;
import com.pi.PoslovnaBanka.service.KursnaListaServiceInterface;
import com.pi.PoslovnaBanka.service.RacunPravnogLicaServiceInterface;

@RestController
@RequestMapping("api/banka")
@CrossOrigin(origins = "*")
public class BankaController {
	
	@Autowired
	BankaServiceInterface bankaServiceInterface;
	
	@Autowired
	KursnaListaServiceInterface kursnaListaServiceInterface;
	
	@Autowired
	KursUValutiServiceInterface kursUValutiServiceInterface;
	
	@Autowired
	RacunPravnogLicaServiceInterface racunPravnogLicaServiceInterface;
	
	@GetMapping
	private ResponseEntity<BankaPoNazivuDTO> getBankaPoNazivu(@RequestParam("naziv") String naziv) {
		Banka banka = bankaServiceInterface.getBankByName(naziv);
		if (banka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new BankaPoNazivuDTO(banka), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<BankaDTO> saveBanka(@RequestBody BankaDTO bankaDTO){
		if (bankaDTO == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		List<Banka> banks = bankaServiceInterface.findAll();
		for(Banka bankaa : banks) {
			if(bankaa.getId() == bankaDTO.getId())
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Banka b = new Banka();
		b.setNaziv(bankaDTO.getNaziv());
		b.setSifraBanke(bankaDTO.getSifraBanke());
		b.setPIB(bankaDTO.getPIB());
		b.setFax(bankaDTO.getFax());
		b.setEmail(bankaDTO.getEmail());
		b.setSWIFT(bankaDTO.getSWIFT());
		b.setTelefon(bankaDTO.getTelefon());
		b.setAdresa(bankaDTO.getAdresa());
		b.setStanje(bankaDTO.getStanje());
		b.setVazeci(true);
		b.setWeb(bankaDTO.getWeb());
		
		KursnaLista kursnaLista;
		if(b.getKursnaLista().iterator().hasNext()) {
			kursnaLista = b.getKursnaLista().iterator().next();
		} else {
			kursnaLista = new KursnaLista();
		}
		kursnaLista.setBanka(b);
		
		b = bankaServiceInterface.save(b);
		return new ResponseEntity<BankaDTO>(new BankaDTO(b), HttpStatus.OK);	
	}
	
	@GetMapping(value="/banke")
	private ResponseEntity<List<BankaDTO>> getBanke() {
		List<Banka> banke = bankaServiceInterface.findAll();
		if (banke == null) {
			return new ResponseEntity<List<BankaDTO>>(HttpStatus.NOT_FOUND);
		}
		List<BankaDTO> bankaDTOs = new ArrayList<>();
		for (Banka b : banke) {
			bankaDTOs.add(new BankaDTO(b));
		}
		return new ResponseEntity<List<BankaDTO>>(bankaDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<BankaDTO> getBanka(@PathVariable("id") Integer id){
		Banka b = bankaServiceInterface.findOne(id);
		if(b == null || b.isVazeci() == false){
			return new ResponseEntity<BankaDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BankaDTO>(new BankaDTO(b), HttpStatus.OK);
	}

	@PutMapping(value="/kursnalista/{id}", consumes="application/json")
	public ResponseEntity<KursnaListaDTO> updateBankaKursnaLista(@RequestBody KursnaListaDTO lista, @PathVariable("id") Integer id){
		KursnaLista kl = kursnaListaServiceInterface.findOne(id);
		if (kl == null) {
			return new ResponseEntity<KursnaListaDTO>(HttpStatus.BAD_REQUEST);
		}
		kl.setBrojKursneListe(lista.getBrojKursneListe());
		kl.setDatum(lista.getDatum());
		kl.setPrimenjujeSeOd(lista.getPrimenjujeSeOd());
	
		kursnaListaServiceInterface.save(kl);
		
		for(KursUValutiDTO kvDTO : lista.getKursUValuti()) {
			KursUValuti kv = kursUValutiServiceInterface.findOne(kvDTO.getRedniBroj());
			if(kv == null)
				kv = new KursUValuti();
			
			kv.setKupovni(kvDTO.getKupovni());
			kv.setKursnaLista(kl);
			kv.setProdajni(kvDTO.getProdajni());
			kv.setRedniBroj(kvDTO.getRedniBroj());
			kv.setSrednji(kvDTO.getSrednji());
			kursUValutiServiceInterface.save(kv);
		}

		return new ResponseEntity<KursnaListaDTO>(lista, HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<BankaDTO> updateBanka(@RequestBody BankaDTO bankaDTO, @PathVariable("id") Integer id){
		Banka banka = bankaServiceInterface.findOne(id);
		if (banka == null) {
			return new ResponseEntity<BankaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		banka.setSifraBanke(bankaDTO.getSifraBanke());
		banka.setNaziv(bankaDTO.getNaziv());
		banka.setAdresa(bankaDTO.getAdresa());
		banka.setEmail(bankaDTO.getEmail());
		banka.setWeb(bankaDTO.getWeb());
		banka.setFax(bankaDTO.getFax());
		banka.setTelefon(bankaDTO.getTelefon());
		banka.setStanje(bankaDTO.getStanje());
		banka.setVazeci(bankaDTO.isVazeci());
		banka.setSWIFT(bankaDTO.getSWIFT());
		banka.setPIB(bankaDTO.getPIB());
		
		KursnaLista kursnaLista;
		if(banka.getKursnaLista().iterator().hasNext()) {
			kursnaLista = banka.getKursnaLista().iterator().next();
		} else {
			kursnaLista = new KursnaLista();
		}
		kursnaLista.setBanka(banka);
		
		RacunPravnogLica racunPravnogLica;
		if(banka.getRacunPravnogLica().iterator().hasNext()) {
			racunPravnogLica = banka.getRacunPravnogLica().iterator().next();
		}else {
			racunPravnogLica = new RacunPravnogLica();
		}
		racunPravnogLica.setBanka(banka);
				
		bankaServiceInterface.save(banka);
		return new ResponseEntity<BankaDTO>(new BankaDTO(banka), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Void> deleteBanke(@PathVariable("id") Integer id){
		
		Banka banka = bankaServiceInterface.findOne(id);
		if(id == null || banka.isVazeci() == false) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		bankaServiceInterface.remove(banka);
		//Set<Poruka> porukeBankeNalogodavca = (Set<Poruka>) banka.getBankaNalogodavac();
		/*System.out.println(porukeBankeNalogodavca);
		//ArrayList<Poruka> porukeBankeNalogodavca = (ArrayList<Poruka>) banka.getBankaNalogodavac();
		Set<Poruka> porukeBankePoverioca = (Set<Poruka>) banka.getBankaPoverilac();
		Set<KursnaLista> kursneListeBanke = (Set<KursnaLista>) banka.getKursnaLista();
		Set<RacunPravnogLica> racuniPravnihLicaBanke = (Set<RacunPravnogLica>) banka.getRacunPravnogLica();
		System.out.println(porukeBankeNalogodavca);
		System.out.println(porukeBankePoverioca);
		System.out.println(porukeBankePoverioca);
		System.out.println(racuniPravnihLicaBanke);
		if (banka != null ){
			if(porukeBankeNalogodavca != null) {
				for(Poruka p : porukeBankeNalogodavca) {
					if(p !=  null)
						bankaServiceInterface.remove(p.getId());
				}
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			if(porukeBankePoverioca != null) {
				for(Poruka por: porukeBankePoverioca) {
					if(por != null)
						bankaServiceInterface.remove(por.getId());	
			}
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			if(kursneListeBanke != null ) {
				for(KursnaLista kursnaLista: kursneListeBanke) {
					if(kursnaLista != null)
						kursnaListaServiceInterface.remove(kursnaLista.getId());
			}
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			if(racuniPravnihLicaBanke != null) {
			for(RacunPravnogLica racun: racuniPravnihLicaBanke) {
				if(racun != null)
					racunPravnogLicaServiceInterface.remove(racun.getId());
			}
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			bankaServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<Void>(HttpStatus.OK);
		
		}*/
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

