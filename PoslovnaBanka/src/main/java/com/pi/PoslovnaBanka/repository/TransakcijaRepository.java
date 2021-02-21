package com.pi.PoslovnaBanka.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pi.PoslovnaBanka.entity.Transakcija;

public interface TransakcijaRepository extends JpaRepository<Transakcija, Integer>{

	@Query(value = "SELECT * FROM transakcije LEFT JOIN racuni_pravnih_lica ON transakcije.racun_duznika = racuni_pravnih_lica.broj_racuna LEFT JOIN klijenti ON racuni_pravnih_lica.klijent = klijenti.klijent_id WHERE racuni_pravnih_lica.broj_racuna = ? AND transakcije.datum_prijema BETWEEN ? AND ?", nativeQuery=true)
	List<Transakcija> getTransactionByAccountNumberAndTimeRange(String accountNumber, Date fromDate, Date toDate);
}
