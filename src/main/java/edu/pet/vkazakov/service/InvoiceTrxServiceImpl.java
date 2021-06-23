package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.InvoiceTrx;
import edu.pet.vkazakov.repository.InvoiceTrxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class InvoiceTrxServiceImpl implements InvoiceTrxService {
	@Autowired
    InvoiceTrxRepository repository;

	public InvoiceTrxServiceImpl(InvoiceTrxRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<InvoiceTrx> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<InvoiceTrx> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<InvoiceTrx> findAll() {
		return (List<InvoiceTrx>) repository.findAll();
	}

	@Override
	public InvoiceTrx save(InvoiceTrx invoiceTrx) {
		return repository.save(invoiceTrx);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
