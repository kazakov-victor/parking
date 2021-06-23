package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Transfer;

import java.util.List;

public interface TransferService {
	Transfer findById(Long id);
	List<Transfer> search(String keyword);
	List<Transfer> findAll();
	Transfer save(Transfer transfer);
	void deleteById(Long id);
}
