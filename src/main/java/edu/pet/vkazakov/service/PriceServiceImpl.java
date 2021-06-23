package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Price;
import edu.pet.vkazakov.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
//@Transactional
public class PriceServiceImpl implements PriceService {
	@Autowired
    PriceRepository repository;

	public PriceServiceImpl(PriceRepository repository) {
		this.repository = repository;
	}

	@Override
	public Price findById(Long id) {
		return repository.findById(id).orElse(new Price());
	}

	@Override
	public double searchCurrentPrice(Date start, Date end, long service) {
		double price = repository.searchCurrentPrice(start, end, service);
		return price;
	}

	@Override
	public List<Price> searchPriceByAmount(String keyword) 	{
		return (List<Price>) repository.searchPriceByAmount(keyword);
	}


	@Override
	public List<Price> findAll() {
		return (List<Price>) repository.findAll();
	}

	@Override
	public Price save(Price price) {
		return repository.save(price);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
