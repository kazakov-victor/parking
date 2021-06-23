package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.InvoiceTrx;

import java.util.List;
import java.util.Optional;

public interface InvoiceTrxService {
	Optional<InvoiceTrx> findById(Long id);
	List<InvoiceTrx> search(String keyword);
	List<InvoiceTrx> findAll();
	InvoiceTrx save(InvoiceTrx invoiceTrx);
	void deleteById(Long id);
}
