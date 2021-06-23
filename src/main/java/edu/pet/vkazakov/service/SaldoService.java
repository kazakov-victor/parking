package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Saldo;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface SaldoService {
	Optional<Saldo> findById(Long id);
	List<Saldo> search(Date sqlData);
	List<Saldo> findAll();
	Saldo save(Saldo saldo);
	void deleteAll ();
}
