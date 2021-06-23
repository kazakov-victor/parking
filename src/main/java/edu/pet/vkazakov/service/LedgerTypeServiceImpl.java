package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.LedgerType;
import edu.pet.vkazakov.repository.LedgerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class LedgerTypeServiceImpl implements LedgerTypeService {
	@Autowired
    LedgerTypeRepository repository;

	public LedgerTypeServiceImpl(LedgerTypeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<LedgerType> findById(Long id) {
		return repository.findById(id);
	}

	/*@Override
	public List<LedgerType> search(String keyword) {
		return repository.search(keyword);
	}*/

	@Override
	public List<LedgerType> findAll() {
		return (List<LedgerType>) repository.findAll();
	}

	@Override
	public LedgerType save(LedgerType ledgerType) {
		return repository.save(ledgerType);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
