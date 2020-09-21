package com.pi.PoslovnaBanka.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.dto.TransakcijaDTO;
import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;
import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.entity.Status;
import com.pi.PoslovnaBanka.entity.TipGreske;
import com.pi.PoslovnaBanka.entity.Transakcija;
import com.pi.PoslovnaBanka.entity.VrstaPlacanja;
import com.pi.PoslovnaBanka.repository.DnevnoStanjeRacunaRepository;
import com.pi.PoslovnaBanka.repository.KlijentRepository;
import com.pi.PoslovnaBanka.repository.TransakcijaRepository;
import com.pi.PoslovnaBanka.repository.ValutaRepository;
import com.pi.PoslovnaBanka.repository.VrstaPlacanjaRepository;

@Service
@Transactional
public class TransakcijaService implements TransakcijaServiceInterface {
	
	@Autowired
	TransakcijaRepository transakcijaRepo;
	
	@Autowired
	KlijentRepository klijentRepo;
	
	@Autowired
	ValutaRepository valutaRepo;
	
	@Autowired
	VrstaPlacanjaRepository vrstaRepo;
	
	@Autowired
	DnevnoStanjeRacunaRepository dnevnoStanje;

	@Override
	public Transakcija findOne(int id) {
		return transakcijaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Transakcija> findAll() {
		return transakcijaRepo.findAll();
	}

	@Override
	public int save(TransakcijaDTO transakcijaDTO) {
		Transakcija transakcija = new Transakcija();
		transakcija.setDuznik(transakcijaDTO.getDuznik());
		transakcija.setPoverilac(transakcijaDTO.getPoverilac());
		transakcija.setSvrhaPlacanja(transakcijaDTO.getSvrhaPlacanja());
		transakcija.setDatumPrijema((Date) new java.util.Date());
		transakcija.setDatumValute((Date) new java.util.Date());
		transakcija.setRacunDuznika(transakcijaDTO.getRacunDuznika());
		
		if(transakcijaDTO.getModelZaduzenja() == 0) {
			transakcija.setModelZaduzenja(289);
		} else {
			transakcija.setModelZaduzenja(transakcijaDTO.getModelZaduzenja());		
		}
		
		transakcija.setPozivNaBrojZaduzenja(transakcijaDTO.getPozivNaBrojZaduzenja());
		
		if(transakcijaDTO.getModelOdobrenja() == 0) {
			transakcija.setModelOdobrenja(97);
		} else {
			transakcija.setModelOdobrenja(transakcijaDTO.getModelOdobrenja());
		}
		
		transakcija.setPozivNaBrojOdobrenja(transakcijaDTO.getPozivNaBrojOdobrenja());
		transakcija.setIznos(transakcijaDTO.getIznos() + 15); //provizija za online placanja uz iznos
		transakcija.setHitno(transakcijaDTO.isHitno());
		transakcija.setSmer(transakcijaDTO.getSmerTransakcije());
		
		DnevnoStanjeRacuna dnevnoStanjeRacuna = dnevnoStanje.getStateByUserId(Integer.parseInt(transakcijaDTO.getDuznik()));
		
		Klijent klijent = klijentRepo.findById(Integer.parseInt(transakcijaDTO.getDuznik())).orElse(null);
		
		return transakcijaRepo.save(transakcija).getBrojStavke();
	}

	@Override
	public boolean remove(int id) {
		transakcijaRepo.deleteById(id);
		return true;
	}

}
