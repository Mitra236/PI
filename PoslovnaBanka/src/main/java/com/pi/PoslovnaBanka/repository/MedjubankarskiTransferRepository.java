package com.pi.PoslovnaBanka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pi.PoslovnaBanka.entity.Poruka;

public interface MedjubankarskiTransferRepository extends JpaRepository<Poruka, Integer>{

	@Query(value = "SELECT * FROM poruke AS p LEFT JOIN poruka_u_paketu AS pp ON p.poruka_id = pp.poruka LEFT JOIN transakcije AS t ON pp.transakcija = t.transakcija_id WHERE t.transakcija_id = ?", nativeQuery=true)
	List<Poruka> findByTransaction(int id);
}
