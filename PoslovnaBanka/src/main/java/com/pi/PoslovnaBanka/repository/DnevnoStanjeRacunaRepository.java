package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;

public interface DnevnoStanjeRacunaRepository extends JpaRepository<DnevnoStanjeRacuna, Integer>{

	@Query(value = "SELECT * FROM dnevno_stanje_racuna LEFT JOIN racuni_pravnih_lica ON dnevno_stanje_racuna.racun_pravnog_lica = racuni_pravnih_lica.racun_pravnog_lica_id LEFT JOIN klijenti ON klijenti.klijent_id = racuni_pravnih_lica.klijent WHERE klijent_id = ?", nativeQuery=true)
	DnevnoStanjeRacuna getStateByUserId(int id);
}
