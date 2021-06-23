package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Payment;
import edu.pet.vkazakov.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class PaymentServiceImpl implements PaymentService {
	@Autowired
    PaymentRepository repository;

	public PaymentServiceImpl(PaymentRepository repository) {
		this.repository = repository;
	}

	@Override
	public Payment findById(Long id) {
		return repository.findById(id).orElse(new Payment());
	}

/*
	@Override
	public List<Payment> search(String keyword) {
		return repository.search(keyword);
	}
*/

	@Override
	public Double sumByContractIdAndPeriod(Long contract_id, Long period_id) {
		return repository.sumByContractIdAndPeriod(contract_id, period_id);
	}


	@Override
	public List<Payment> findAll() {
		return (List<Payment>) repository.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		return repository.save(payment);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
