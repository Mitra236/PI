package com.pi.PoslovnaBanka.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.PoslovnaBanka.entity.Klijent;

public interface KlijentRepository extends JpaRepository<Klijent, Integer>{

	Page<Klijent> findAll(Pageable pageable);
}
