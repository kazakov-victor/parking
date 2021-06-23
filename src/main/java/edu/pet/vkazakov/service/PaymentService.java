package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Payment;

import java.util.List;

public interface PaymentService {
	Payment findById(Long id);
//	List<Payment> search(String keyword);
	Double sumByContractIdAndPeriod(Long contract_id, Long period_id);
	List<Payment> findAll();
	Payment save(Payment payment);
	void deleteById(Long id);
}
