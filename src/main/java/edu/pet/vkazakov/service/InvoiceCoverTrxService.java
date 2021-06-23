package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.InvoiceCoverTrx;

import java.util.List;
import java.util.Optional;

public interface InvoiceCoverTrxService {
	Optional<InvoiceCoverTrx> findById(Long id);
	List<InvoiceCoverTrx> findAll();
	InvoiceCoverTrx save(InvoiceCoverTrx invoiceCoverTrx);
	void deleteById(Long id);
}
