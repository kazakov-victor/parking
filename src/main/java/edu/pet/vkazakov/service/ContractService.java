package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Contract;

import java.sql.Date;
import java.util.List;

public interface ContractService {
	Contract findById(Long id);
	List<Long> searchByPeriod(Date start, Date end);
	List<Contract> findAll();
	Contract save(Contract contract);
	void deleteById(Long id);
}
