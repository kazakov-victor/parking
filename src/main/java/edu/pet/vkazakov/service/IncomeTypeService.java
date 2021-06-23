package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.IncomeType;

import java.util.List;

public interface IncomeTypeService {
	List<IncomeType> findAll();
	IncomeType findById(Long id);
	IncomeType save(IncomeType income);
	void deleteById(Long id);
}
