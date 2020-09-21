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
import com.pi.PoslovnaBanka.repository.KlijentRepository;

@Service
public class KlijentService implements KlijentServiceInterface {
	
	@Autowired
	KlijentRepository klijentRepo;

	@Override
	public KlijentDTO findOne(int id) {
		return new KlijentDTO(klijentRepo.findById(id).orElse(null));
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
		Klijent klijent = new Klijent();
		klijent.setAdresa(klijentDTO.getAdresa());
		klijent.setIme(klijentDTO.getIme());
		klijent.setPrezime(klijentDTO.getPrezime());
		klijent.setJMBG(klijentDTO.getJMBG());
		klijent.setEmail(klijent.getEmail());
		klijent.setTelefon(klijentDTO.getTelefon());
		klijent.setAdresa(klijentDTO.getAdresa());
		klijent.setUloga(klijentDTO.getUloga());
		return klijentRepo.save(klijent).getId();
	}

	@Override
	public boolean remove(int id) {
		klijentRepo.deleteById(id);
		return true;
	}

	@Override
	public List<KlijentDTO> findAll() {
		List<KlijentDTO> klijentDTOs = new ArrayList<>();
		for(Klijent k: klijentRepo.findAll()) {
			klijentDTOs.add(new KlijentDTO(k));
		}
		return klijentDTOs;
	}

}
