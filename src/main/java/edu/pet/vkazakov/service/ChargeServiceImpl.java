package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Charge;
import edu.pet.vkazakov.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class ChargeServiceImpl implements ChargeService {
	@Autowired
    ChargeRepository repository;

	public ChargeServiceImpl(ChargeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Charge> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Charge> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Charge> findAll() {
		return (List<Charge>) repository.findAll();
	}

	@Override
	public Charge save(Charge charge) {
		return repository.save(charge);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
