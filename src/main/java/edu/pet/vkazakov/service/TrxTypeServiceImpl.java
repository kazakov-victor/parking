package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.TrxType;
import edu.pet.vkazakov.repository.TrxTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class TrxTypeServiceImpl implements TrxTypeService {
	@Autowired
    TrxTypeRepository repository;

	public TrxTypeServiceImpl(TrxTypeRepository repository) {
		this.repository = repository;
	}

	@Override
	public TrxType findById(Long id) {
		return repository.findById(id).orElse(new TrxType());
	}

	@Override
	public List<TrxType> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<TrxType> findAll() {
		return (List<TrxType>) repository.findAll();
	}

	@Override
	public TrxType save(TrxType trxType) {
		return repository.save(trxType);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
