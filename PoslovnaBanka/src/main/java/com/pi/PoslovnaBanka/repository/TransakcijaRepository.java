package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.PoslovnaBanka.entity.Transakcija;

public interface TransakcijaRepository extends JpaRepository<Transakcija, Integer>{

}
