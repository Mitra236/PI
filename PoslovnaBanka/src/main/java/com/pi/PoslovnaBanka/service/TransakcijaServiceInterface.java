package com.pi.PoslovnaBanka.service;

import java.sql.Date;
import java.util.List;

import com.pi.PoslovnaBanka.dto.TransakcijaDTO;
import com.pi.PoslovnaBanka.entity.Transakcija;

public interface TransakcijaServiceInterface {

	TransakcijaDTO findOne(int id);
	List<Transakcija> findAll();
	int save(TransakcijaDTO transakcija) throws Exception ;
	boolean remove(int id);
	List<TransakcijaDTO> getTransactionByAccountNumberAndTimeRange(String accountNumber, Date fromDate, Date toDate);
	List<TransakcijaDTO> getTransactionByAccountNumber(String accountNumber);
}
