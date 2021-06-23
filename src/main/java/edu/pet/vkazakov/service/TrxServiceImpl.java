package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Trx;
import edu.pet.vkazakov.repository.TrxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class TrxServiceImpl implements TrxService {
	@Autowired
    TrxRepository repository;

	public TrxServiceImpl(TrxRepository repository) {
		this.repository = repository;
	}

	@Override
	public Trx findById(Long id) {
		return repository.findById(id).orElse(new Trx());
	}

	@Override
	public List<Trx> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Trx> findAll() {
		return (List<Trx>) repository.findAll();
	}

	@Override
	public Trx save(Trx trx) {
		return repository.save(trx);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
