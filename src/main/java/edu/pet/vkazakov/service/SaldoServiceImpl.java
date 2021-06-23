package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Saldo;
import edu.pet.vkazakov.repository.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class SaldoServiceImpl implements SaldoService {
	@Autowired
    SaldoRepository repository;

	public SaldoServiceImpl(SaldoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Saldo> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Saldo> search(Date sqlData) {
		return (List<Saldo>) repository.search(sqlData);
	}

	@Override
	public List<Saldo> findAll() {
		return (List<Saldo>) repository.findAll();
	}

	@Override
	public Saldo save(Saldo saldo) {
		return repository.save(saldo);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	}
