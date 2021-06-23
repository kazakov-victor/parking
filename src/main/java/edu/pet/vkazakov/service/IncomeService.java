package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Income;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IncomeService {
	List<Income> findAll();
	Optional<Income> findById(Long id);
	Optional<Income> findByName(String name);
	List<Income> searchByContractByPeriod(Long id, Date start, Date end);
	List<Income> searchByContractByPeriodByBasis(Long id, Date start, Date end, String basis);
	Income save(Income income);
	void deleteById(Long id);
}
