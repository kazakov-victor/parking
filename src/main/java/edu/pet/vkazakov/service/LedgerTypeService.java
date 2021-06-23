package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.LedgerType;

import java.util.List;
import java.util.Optional;

public interface LedgerTypeService {
	Optional<LedgerType> findById(Long id);
//	List<LedgerType> search(String keyword);
	List<LedgerType> findAll();
	LedgerType save(LedgerType ledgerType);
	void deleteById(Long id);
}
