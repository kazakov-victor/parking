package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.PaymentType;
import edu.pet.vkazakov.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class PaymentTypeServiceImpl implements PaymentTypeService {
	@Autowired
    PaymentTypeRepository repository;

	public PaymentTypeServiceImpl(PaymentTypeRepository repository) {
		this.repository = repository;
	}

	@Override
	public PaymentType findById(Long id) {
		return repository.findById(id).orElse(new PaymentType());
	}

/*
	@Override
	public List<PaymentType> search(String keyword) {
		return repository.search(keyword);
	}
*/

	@Override
	public List<PaymentType> findAll() {
		return (List<PaymentType>) repository.findAll();
	}

	@Override
	public PaymentType save(PaymentType paymentTypeType) {
		return repository.save(paymentTypeType);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	/*@Override
	public List<PaymentType> list(){return (List<PaymentType>) repository.list(); }*/
}
