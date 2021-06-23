package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Balance;
import edu.pet.vkazakov.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class BalanceServiceImpl implements BalanceService {
	@Autowired
    BalanceRepository repository;

	public BalanceServiceImpl(BalanceRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Balance> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Balance> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Balance> findAll() {
		return (List<Balance>) repository.findAll();
	}

	@Override
	public Balance save(Balance balance) {
		return repository.save(balance);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
