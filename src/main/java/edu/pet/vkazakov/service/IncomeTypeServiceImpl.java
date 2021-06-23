package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.IncomeType;
import edu.pet.vkazakov.repository.IncomeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IncomeTypeServiceImpl implements IncomeTypeService {

	@Autowired
    IncomeTypeRepository repository;

	public IncomeTypeServiceImpl(IncomeTypeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<IncomeType> findAll() {
		return (List<IncomeType>) repository.findAll();
	}

	@Override
	public IncomeType findById(Long id) {	return repository.findById(id).orElse(new IncomeType());	}

	@Override
	public IncomeType save(IncomeType incomeType) {
		return repository.save(incomeType);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}