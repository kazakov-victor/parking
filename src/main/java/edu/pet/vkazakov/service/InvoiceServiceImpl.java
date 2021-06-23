package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Invoice;
import edu.pet.vkazakov.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
    InvoiceRepository repository;

	public InvoiceServiceImpl(InvoiceRepository repository) {
		this.repository = repository;
	}

	@Override
	public Invoice findById(Long id) {
		return repository.findById(id).orElse(new Invoice());
	}

	@Override
	public List<Invoice> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Invoice> findAll() {
		return (List<Invoice>) repository.findAll();
	}

	@Override
	public Invoice save(Invoice invoice) {
		return repository.save(invoice);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
