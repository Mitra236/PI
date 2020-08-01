package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.PoslovnaBanka.entity.Poruka;

public interface MedjubankarskiTransferRepository extends JpaRepository<Poruka, Integer>{

}
