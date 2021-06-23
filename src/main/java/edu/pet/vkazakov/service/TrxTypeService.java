package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.TrxType;

import java.util.List;

public interface TrxTypeService {
	TrxType findById(Long id);
	List<TrxType> search(String keyword);
	List<TrxType> findAll();
	TrxType save(TrxType trxType);
	void deleteById(Long id);
}
