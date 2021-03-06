package com.pi.PoslovnaBanka.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.dto.TransakcijaDTO;
import com.pi.PoslovnaBanka.entity.Banka;
import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;
import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.entity.Poruka;
import com.pi.PoslovnaBanka.entity.PorukeUPaketu;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.entity.Transakcija;
import com.pi.PoslovnaBanka.entity.VrstaPoruke;
import com.pi.PoslovnaBanka.repository.BankaRepository;
import com.pi.PoslovnaBanka.repository.DnevnoStanjeRacunaRepository;
import com.pi.PoslovnaBanka.repository.KlijentRepository;
import com.pi.PoslovnaBanka.repository.MedjubankarskiTransferRepository;
import com.pi.PoslovnaBanka.repository.PorukaUPaketuRepository;
import com.pi.PoslovnaBanka.repository.RacunPravnogLicaRepository;
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
	
	@Autowired
	BankaRepository bankaRepo;
	
	@Autowired
	RacunPravnogLicaRepository racunPravnogLicaRepo;
	
	@Autowired
	MedjubankarskiTransferRepository porukaRepo;
	
	@Autowired
	PorukaUPaketuRepository porukaUPaketuRepo;
	
	@Override
	public TransakcijaDTO findOne(int id) {
		return new TransakcijaDTO(transakcijaRepo.findById(id).orElse(null));
	}

	@Override
	public List<Transakcija> findAll() {
		return transakcijaRepo.findAll();
	}

	@Override
	public int save(TransakcijaDTO transakcijaDTO) throws Exception {
		Transakcija transakcija = new Transakcija();
		Klijent duznik = klijentRepo.getUserByAccountNumber(transakcijaDTO.getRacunDuznika());
		Klijent poverilac = klijentRepo.getUserByAccountNumber(transakcijaDTO.getRacunPoverioca());
		
		if(duznik == null || poverilac == null) {
			throw new Exception("Uneli ste pogresan broj racuna, molimo vas pokusajte ponovo.");
		}
		
		transakcija.setDuznik(transakcijaDTO.getDuznik());
		transakcija.setPoverilac(transakcijaDTO.getPoverilac());
		transakcija.setSvrhaPlacanja(transakcijaDTO.getSvrhaPlacanja());
		transakcija.setDatumPrijema(Date.valueOf(LocalDate.now()));
		transakcija.setDatumValute(Date.valueOf(LocalDate.now()));
		transakcija.setRacunDuznika(transakcijaDTO.getRacunDuznika());
		transakcija.setRacunPoverioca(transakcijaDTO.getRacunPoverioca());
		
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
		double amount = transakcijaDTO.getIznos() + 15; //provizija za online placanja
		transakcija.setIznos(amount);
		transakcija.setHitno(transakcijaDTO.isHitno());
		transakcija.setSmer(transakcijaDTO.getSmerTransakcije());
		
		DnevnoStanjeRacuna dnevnoStanjeRacunaDuznika = dnevnoStanje.getStateByUserId(duznik.getId());
		
		if(dnevnoStanjeRacunaDuznika.getTrenutnoStanje() < transakcijaDTO.getIznos()) {
			try {
				throw new Exception("Nemate dovoljno novca na racunu");
			} catch (Exception e) {}
		} else {
			dnevnoStanjeRacunaDuznika.setTrenutnoStanje(dnevnoStanjeRacunaDuznika.getTrenutnoStanje() - amount);
			dnevnoStanjeRacunaDuznika.setPrometNaTeret(dnevnoStanjeRacunaDuznika.getPrometNaTeret() + amount);
			dnevnoStanjeRacunaDuznika.setDatumPoslednjegPrometa(Date.valueOf(LocalDate.now()));
			dnevnoStanje.save(dnevnoStanjeRacunaDuznika);
		}
		
		DnevnoStanjeRacuna dnevnoStanjeRacunaPoverioca = dnevnoStanje.getStateByUserId(poverilac.getId());
		
		dnevnoStanjeRacunaPoverioca.setTrenutnoStanje(dnevnoStanjeRacunaPoverioca.getTrenutnoStanje() + transakcijaDTO.getIznos());
		dnevnoStanjeRacunaPoverioca.setPrometNaTeret(dnevnoStanjeRacunaPoverioca.getPrometUKorist() + transakcijaDTO.getIznos());
		dnevnoStanjeRacunaPoverioca.setDatumPoslednjegPrometa(Date.valueOf(LocalDate.now()));
		dnevnoStanje.save(dnevnoStanjeRacunaPoverioca);
		
		RacunPravnogLica racunDuznika = racunPravnogLicaRepo.getAccountByUserAndAccountNumber(duznik.getId(), transakcijaDTO.getRacunDuznika());
		RacunPravnogLica racunPoverioca = racunPravnogLicaRepo.getAccountByUserAndAccountNumber(poverilac.getId(), transakcijaDTO.getRacunPoverioca());
		

		if(transakcijaDTO.getValuta() != null) {
			transakcija.setValuta(valutaRepo.findById(transakcijaDTO.getValuta().getId()).orElse(null));
		} else {transakcija.setValuta(racunDuznika.getValuta());}
		
		Integer saved = transakcijaRepo.save(transakcija).getBrojStavke();
		
		
		if(racunDuznika.getBanka() != racunPoverioca.getBanka()) {
			Poruka poruka = new Poruka();
			poruka.setUkupanIznos(amount);
			poruka.setRacunNalogodavca(racunDuznika.getBanka());
			poruka.setRacunPoverioca(racunPoverioca.getBanka());
			
			if(amount < 200000) {
				poruka.setTip(VrstaPoruke.MT102);
			} else {
				poruka.setTip(VrstaPoruke.MT103);
			}
			
			porukaRepo.save(poruka);
			
			transakcija.setImaPoruku(true);
			transakcijaRepo.save(transakcija).getBrojStavke();
			//poruka u paketu
			
			PorukeUPaketu porukeUPaketu = new PorukeUPaketu();
			porukeUPaketu.setPoruka(poruka);
			porukeUPaketu.setTransakcija(transakcija);
			
			porukaUPaketuRepo.save(porukeUPaketu);
			
			Banka bankaNalogodavac = bankaRepo.findById(racunDuznika.getBanka().getId()).orElse(null);
			bankaNalogodavac.setStanje(bankaNalogodavac.getStanje() - amount);
			bankaRepo.save(bankaNalogodavac);
			
			Banka bankaPoverilac = bankaRepo.findById(racunPoverioca.getBanka().getId()).orElse(null);
			bankaPoverilac.setStanje(bankaPoverilac.getStanje() + amount);
			bankaRepo.save(bankaPoverilac);		
		}
		
		return saved;
	}

	@Override
	public boolean remove(int id) {
		transakcijaRepo.deleteById(id);
		return true;
	}

	@Override
	public List<TransakcijaDTO> getTransactionByAccountNumberAndTimeRange(String accountNumber, Date fromDate,
			Date toDate) {
		List<TransakcijaDTO> transakcijaDTOs = new ArrayList<TransakcijaDTO>();
		for(Transakcija t: transakcijaRepo.getTransactionByAccountNumberAndTimeRange(accountNumber, fromDate, toDate)) {
			transakcijaDTOs.add(new TransakcijaDTO(t));
		}
		return transakcijaDTOs;
	}
	
	@Override
	public List<TransakcijaDTO> getTransactionByAccountNumber(String accountNumber) {
		List<TransakcijaDTO> transakcijaDTOs = new ArrayList<TransakcijaDTO>();
		for(Transakcija t: transakcijaRepo.getTransactionByAccountNumber(accountNumber)) {
			transakcijaDTOs.add(new TransakcijaDTO(t));
		}
		return transakcijaDTOs;
	}

}
