package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Vat;

import java.util.List;

public interface VatService {
	Vat findById(Long id);
	List<Vat> search(String keyword);
	List<Vat> findAll();
	Vat save(Vat vat);
	void deleteById(Long id);
}
