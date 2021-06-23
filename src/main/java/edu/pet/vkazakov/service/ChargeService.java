package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Charge;

import java.util.List;
import java.util.Optional;

public interface ChargeService {
	Optional<Charge> findById(Long id);
	List<Charge> search(String keyword);
	List<Charge> findAll();
	Charge save(Charge charge);
	void deleteById(Long id);
}
