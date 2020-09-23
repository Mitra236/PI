package com.pi.PoslovnaBanka.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pi.PoslovnaBanka.entity.Klijent;

public interface KlijentRepository extends JpaRepository<Klijent, Integer>{

//	@Query(value = "SELECT * FROM klijenti LEFT JOIN racuni_pravnih_lica ON klijenti.klijent_id = racuni_pravnih_lica.klijent WHERE racuni_pravnih_lica.vazeci = 1", nativeQuery = true)
//	List<Klijent> findAll();
	Page<Klijent> findAll(Pageable pageable);
	@Query(value = "SELECT * FROM klijenti LEFT JOIN racuni_pravnih_lica ON klijenti.klijent_id = racuni_pravnih_lica.klijent WHERE racuni_pravnih_lica.broj_racuna = ?", nativeQuery = true)
	Klijent getUserByAccountNumber(String racunPoverioca);
}
