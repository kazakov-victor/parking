package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.InvoiceCoverTrx;
import edu.pet.vkazakov.repository.InvoiceCoverTrxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class InvoiceCoverTrxServiceImpl implements InvoiceCoverTrxService {
	@Autowired
    InvoiceCoverTrxRepository repository;

	public InvoiceCoverTrxServiceImpl(InvoiceCoverTrxRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<InvoiceCoverTrx> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<InvoiceCoverTrx> findAll() {
		return (List<InvoiceCoverTrx>) repository.findAll();
	}

	@Override
	public InvoiceCoverTrx save(InvoiceCoverTrx invoiceCoverTrx) {
		return repository.save(invoiceCoverTrx);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
