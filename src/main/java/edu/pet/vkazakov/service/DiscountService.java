package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Discount;

import java.util.List;

public interface DiscountService {
	Discount findById(Long id);
	List<Discount> search(String keyword);
	List<Discount> findAll();
	Discount save(Discount discount);
	void deleteById(Long id);
}
