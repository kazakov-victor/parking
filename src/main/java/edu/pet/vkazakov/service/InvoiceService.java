package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Invoice;

import java.util.List;

public interface InvoiceService {
	Invoice findById(Long id);
	List<Invoice> search(String keyword);
	List<Invoice> findAll();
	Invoice save(Invoice invoice);
	void deleteById(Long id);
}
