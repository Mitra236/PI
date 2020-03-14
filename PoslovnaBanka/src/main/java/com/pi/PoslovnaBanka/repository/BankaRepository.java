package com.pi.PoslovnaBanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.PoslovnaBanka.entity.Banka;

public interface BankaRepository extends JpaRepository<Banka, Integer>{

}
