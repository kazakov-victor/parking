package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Period;
import edu.pet.vkazakov.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

;

@Service
//@Transactional
public class PeriodServiceImpl implements PeriodService {
	@Autowired
    PeriodRepository repository;

	public PeriodServiceImpl(PeriodRepository repository) {
		this.repository = repository;
	}

	@Override
	public Period findById(Long id) {
		return repository.findById(id).orElse(new Period());
	}

	@Override
	public ArrayList<Period> searchOpenPeriod() {
		return repository.searchOpenPeriod();
	}

	@Override
	public Period findByDate(Date date) {
		return repository.findByDate(date);
	}

	@Override
	public Optional<Long> findByDtfrom(Date date) {
		return repository.findByDtfrom(date);
	}

	@Override
	public List<Period> findAll() {
		return (List<Period>) repository.findAll();
	}

	@Override
	public Period save(Period period) {
		return repository.save(period);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
