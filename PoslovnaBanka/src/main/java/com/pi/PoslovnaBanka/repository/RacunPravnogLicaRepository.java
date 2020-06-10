package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pi.PoslovnaBanka.entity.RacunPravnogLica;

public interface RacunPravnogLicaRepository extends JpaRepository<RacunPravnogLica, Integer>{

	@Query(value = "SELECT * FROM racuni_pravnih_lica WHERE klijent = ?", nativeQuery=true)
	RacunPravnogLica getAccountByUser(int client);
}
