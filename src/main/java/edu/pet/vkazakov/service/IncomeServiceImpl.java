package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Income;
import edu.pet.vkazakov.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {

	@Autowired
    IncomeRepository repository;

	public IncomeServiceImpl(IncomeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Income> findAll() {
		return (List<Income>) repository.findAll();
	}

	@Override
	public Optional<Income> findById(Long id) {	return repository.findById(id);	}
/*
	@Override
	public List<Income> findContract(Long id) {
		return repository.findContract(id);	}

 */
	@Override
	public Optional<Income> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Income> searchByContractByPeriod(Long id, Date start, Date end) {
		return repository.searchByContractByPeriod(id, start, end);
	}
	@Override
	public List<Income> searchByContractByPeriodByBasis(Long id, Date start, Date end, String basis) {
		return repository.searchByContractByPeriodByBasis(id, start, end, basis);
	}

	@Override
	public Income save(Income income) {
		return repository.save(income);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}