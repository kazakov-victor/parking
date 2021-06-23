package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Trx;

import java.util.List;

public interface TrxService {
	Trx findById(Long id);
	List<Trx> search(String keyword);
	List<Trx> findAll();
	Trx save(Trx trx);
	void deleteById(Long id);
}
