package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Balance;

import java.util.List;
import java.util.Optional;

public interface BalanceService {
	Optional<Balance> findById(Long id);
	List<Balance> search(String keyword);
	List<Balance> findAll();
	Balance save(Balance balance);
	void deleteById(Long id);
}
