package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Vatrate;

import java.util.List;

public interface VatrateService {
	Vatrate findById(Long id);
	List<Vatrate> search(String keyword);
	List<Vatrate> findAll();
	Vatrate save(Vatrate vatrate);
	void deleteById(Long id);
}
