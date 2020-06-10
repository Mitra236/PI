package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pi.PoslovnaBanka.entity.Banka;

public interface BankaRepository extends JpaRepository<Banka, Integer>{

	@Query(value = "SELECT * FROM banke WHERE naziv_banke = ?", nativeQuery = true)
	Banka getBankByName(String naziv);
}
