package com.pi.PoslovnaBanka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.dto.KlijentDTO;
import com.pi.PoslovnaBanka.entity.Klijent;
import com.pi.PoslovnaBanka.entity.Uloga;
import com.pi.PoslovnaBanka.repository.KlijentRepository;
import com.pi.PoslovnaBanka.repository.RacunPravnogLicaRepository;

@Service
public class KlijentService implements KlijentServiceInterface {
	
	@Autowired
	KlijentRepository klijentRepo;
	
	@Autowired
	RacunPravnogLicaRepository racunPravnogLicaRepo;

	@Override
	public KlijentDTO findOne(int id) {
		Klijent kl = klijentRepo.findById(id).orElse(null);
		if(kl == null)
			return null;
		
		return new KlijentDTO(kl);
	}

	@Override
	public Page<KlijentDTO> findAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Klijent> entities = klijentRepo.findAll(pageable);
		Page<KlijentDTO> dtoPage = entities.map(new Function<Klijent, KlijentDTO>() {
			@Override
			public KlijentDTO apply(Klijent klijent) {
				KlijentDTO klijentDto = new KlijentDTO(klijent);
				return klijentDto;
			}
		});
		return dtoPage;
	}

	@Override
	public int save(KlijentDTO klijentDTO) {
		Klijent klijent = klijentRepo.findById(klijentDTO.getId()).orElse(null);
		if(klijent == null)
			klijent = new Klijent();
		
		klijent.setId(klijentDTO.getId());
		klijent.setAdresa(klijentDTO.getAdresa());
		klijent.setIme(klijentDTO.getIme());
		klijent.setPrezime(klijentDTO.getPrezime());
		klijent.setJMBG(klijentDTO.getJMBG());
		klijent.setEmail(klijentDTO.getEmail());
		klijent.setTelefon(klijentDTO.getTelefon());
		klijent.setAdresa(klijentDTO.getAdresa());
		klijent.setUloga(Uloga.FizickoLice);
		klijent.setVazeci(true);
		return klijentRepo.save(klijent).getId();
	}

	@Override
	public List<Klijent> findAllVazece() {
		List<Klijent> klijenti = new ArrayList<Klijent>();
		for(Klijent k : klijentRepo.findAll())
			if(k.isVazeci() == true) {
				klijenti.add(klijentRepo.getOne(k.getId()));}
		return klijenti;
	}
	@Override
	public List<Klijent> findAll() {
		List<Klijent> klijenti = new ArrayList<Klijent>();
		for(Klijent k : klijentRepo.findAll())
				klijenti.add(klijentRepo.getOne(k.getId()));
		return klijenti;
	}

	@Override
	public KlijentDTO getUserByAccountNumber(String number) {
		Klijent klijent = klijentRepo.getUserByAccountNumber(number);
		return new KlijentDTO(klijent);
	}

	@Override
	public KlijentDTO login(KlijentDTO klijentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(KlijentDTO klijent) {
		Klijent kl = klijentRepo.getOne(klijent.getId());
		kl.setVazeci(false);
		klijentRepo.save(kl);
			
		
	}

}
