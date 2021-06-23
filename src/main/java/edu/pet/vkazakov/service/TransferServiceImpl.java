package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Transfer;
import edu.pet.vkazakov.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class TransferServiceImpl implements TransferService {
	@Autowired
    TransferRepository repository;

	public TransferServiceImpl(TransferRepository repository) {
		this.repository = repository;
	}

	@Override
	public Transfer findById(Long id) {
		return repository.findById(id).orElse(new Transfer());
	}

	@Override
	public List<Transfer> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Transfer> findAll() {
		return (List<Transfer>) repository.findAll();
	}

	@Override
	public Transfer save(Transfer transfer) {
		return repository.save(transfer);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
