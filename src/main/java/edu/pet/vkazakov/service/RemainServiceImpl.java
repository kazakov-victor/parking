package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Remain;
import edu.pet.vkazakov.repository.RemainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class RemainServiceImpl implements RemainService {
	@Autowired
    RemainRepository repository;

	public RemainServiceImpl(RemainRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Remain> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Remain> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Remain> findAll() {
		return (List<Remain>) repository.findAll();
	}

	@Override
	public Remain save(Remain remain) {
		return repository.save(remain);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
