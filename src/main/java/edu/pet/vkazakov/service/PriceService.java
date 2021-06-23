package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Price;

import java.sql.Date;
import java.util.List;

public interface PriceService {
	Price findById(Long id);
	double searchCurrentPrice(Date start, Date end, long service);
	List<Price> searchPriceByAmount (String keyword);
	List<Price> findAll();
	Price save(Price price);
	void deleteById(Long id);
}
