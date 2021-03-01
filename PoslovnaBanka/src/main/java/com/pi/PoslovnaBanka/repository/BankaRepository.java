package com.pi.PoslovnaBanka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pi.PoslovnaBanka.entity.Banka;

public interface BankaRepository extends JpaRepository<Banka, Integer>{

	@Query(value = "SELECT * FROM banke WHERE naziv_banke = ?", nativeQuery = true)
	Banka getBankByName(String naziv);
	
	@Query(value = "SELECT * FROM banke WHERE vazeci = 1", nativeQuery = true)
	List<Banka> getVazeceBanke();
	
	
}
