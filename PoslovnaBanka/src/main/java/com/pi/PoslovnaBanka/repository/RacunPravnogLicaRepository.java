package com.pi.PoslovnaBanka.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pi.PoslovnaBanka.entity.RacunPravnogLica;

public interface RacunPravnogLicaRepository extends JpaRepository<RacunPravnogLica, Integer>{
	
	@Query(value = "SELECT * FROM racuni_pravnih_lica WHERE vazeci = 1", nativeQuery = true)
	Page<RacunPravnogLica> findAll(Pageable pageable);
 
	@Query(value = "SELECT * FROM racuni_pravnih_lica WHERE klijent = ?", nativeQuery=true)
	RacunPravnogLica getAccountByUser(int client);
	
	@Query(value = "SELECT * FROM klijenti LEFT JOIN racuni_pravnih_lica ON klijenti.klijent_id = racuni_pravnih_lica.klijent WHERE klijenti.klijent_id = ? AND racuni_pravnih_lica.broj_racuna = ?", nativeQuery=true)
	RacunPravnogLica getAccountByUserAndAccountNumber(int id, String number);
}
