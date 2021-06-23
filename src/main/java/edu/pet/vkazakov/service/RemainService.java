package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Remain;

import java.util.List;
import java.util.Optional;

public interface RemainService {
	Optional<Remain> findById(Long id);
	List<Remain> search(String keyword);
	List<Remain> findAll();
	Remain save(Remain remain);
	void deleteById(Long id);
}
