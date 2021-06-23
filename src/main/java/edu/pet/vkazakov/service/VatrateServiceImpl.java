package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Vatrate;
import edu.pet.vkazakov.repository.VatrateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class VatrateServiceImpl implements VatrateService {
	@Autowired
    VatrateRepository repository;

	public VatrateServiceImpl(VatrateRepository repository) {
		this.repository = repository;
	}

	@Override
	public Vatrate findById(Long id) {
		return repository.findById(id).orElse(new Vatrate());
	}

	@Override
	public List<Vatrate> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Vatrate> findAll() {
		return (List<Vatrate>) repository.findAll();
	}

	@Override
	public Vatrate save(Vatrate vatrate) {
		return repository.save(vatrate);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
