package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.PoslovnaBanka.entity.DnevnoStanjeRacuna;

public interface DnevnoStanjeRacunaRepository extends JpaRepository<DnevnoStanjeRacuna, Integer>{

}
