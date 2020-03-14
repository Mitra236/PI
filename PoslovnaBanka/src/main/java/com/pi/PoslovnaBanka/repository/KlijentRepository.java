package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.PoslovnaBanka.entity.Klijent;

public interface KlijentRepository extends JpaRepository<Klijent, Integer>{

}
