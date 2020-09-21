package com.pi.PoslovnaBanka.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.PoslovnaBanka.dto.DnevnoStanjeDTO;
import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;
import com.pi.PoslovnaBanka.entity.RacunPravnogLica;
import com.pi.PoslovnaBanka.repository.DnevnoStanjeRacunaRepository;
import com.pi.PoslovnaBanka.repository.RacunPravnogLicaRepository;

@Service
public class DnevnoStanjeRacunaService implements DnevnoStanjeRacunaServiceInterface{
	
	@Autowired
	DnevnoStanjeRacunaRepository dnevnoStanjeRepo;
	
	@Autowired
	RacunPravnogLicaRepository racunPravnogLicaRepo;

	@Override
	public DnevnoStanjeDTO findOne(int id) {
		return new DnevnoStanjeDTO(dnevnoStanjeRepo.findById(id).orElse(null));
	}

	@Override
	public List<DnevnoStanjeDTO> findAll() {
		List<DnevnoStanjeDTO> dnevnoStanjeDTOs = new ArrayList<DnevnoStanjeDTO>();
		for(DnevnoStanjeRacuna d: dnevnoStanjeRepo.findAll()) {
			dnevnoStanjeDTOs.add(new DnevnoStanjeDTO(d));
		}
		return dnevnoStanjeDTOs;
	}

	@Override
	public int save(DnevnoStanjeDTO dnevnoStanje) {
		DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna();
		RacunPravnogLica racunPravnogLica = racunPravnogLicaRepo.findById(dnevnoStanje.getRacunPravnogLica().getId()).orElse(null);
		dnevnoStanjeRacuna.setRacunPravnogLica(racunPravnogLica);
		dnevnoStanje.setPrethodnoStanje(0);
		dnevnoStanje.setPrometNaTeret(0);
		dnevnoStanje.setPrometUKorist(0);
		dnevnoStanje.setDatumPoslednjegPrometa((java.sql.Date) new Date());
		return dnevnoStanjeRepo.save(dnevnoStanjeRacuna).getBrojIzvoda();
	}

	@Override
	public boolean remove(int id) {
		dnevnoStanjeRepo.deleteById(id);
		return true;
	}

	@Override
	public DnevnoStanjeDTO getStateByUser(int id) {
		DnevnoStanjeRacuna dnevnoStanjeDTO = dnevnoStanjeRepo.getStateByUserId(id);
		
		return new DnevnoStanjeDTO(dnevnoStanjeDTO);
	}

}
