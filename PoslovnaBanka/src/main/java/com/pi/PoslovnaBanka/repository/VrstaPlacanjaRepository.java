package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.PoslovnaBanka.entity.VrstaPlacanja;

public interface VrstaPlacanjaRepository extends JpaRepository<VrstaPlacanja, Integer>{

}
