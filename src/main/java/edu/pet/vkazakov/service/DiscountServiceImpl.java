package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Discount;
import edu.pet.vkazakov.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class DiscountServiceImpl implements DiscountService {
	@Autowired
    DiscountRepository repository;

	public DiscountServiceImpl(DiscountRepository repository) {
		this.repository = repository;
	}

	@Override
	public Discount findById(Long id) {
		return repository.findById(id).orElse(new Discount());
	}

	@Override
	public List<Discount> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Discount> findAll() {
		return (List<Discount>) repository.findAll();
	}

	@Override
	public Discount save(Discount discount) {
		return repository.save(discount);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
