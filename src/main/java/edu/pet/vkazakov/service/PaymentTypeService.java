package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.PaymentType;

import java.util.List;

public interface PaymentTypeService {
	PaymentType findById(Long id);
	//List<PaymentType> search(String keyword);
	List<PaymentType> findAll();
	PaymentType save(PaymentType paymentType);
	void deleteById(Long id);
	//List<PaymentType> list();
}
