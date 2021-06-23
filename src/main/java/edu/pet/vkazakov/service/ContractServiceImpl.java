package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Contract;
import edu.pet.vkazakov.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {
	@Autowired
    ContractRepository contractRepository;

	public ContractServiceImpl(ContractRepository contractRepository) {
		this.contractRepository = contractRepository;
	}

	@Override
	public Contract findById(Long id) {
		return contractRepository.findById(id).orElse(new Contract());
	}

	@Override
	public List<Long> searchByPeriod(Date start, Date end) {
		return contractRepository.searchByPeriod(start, end);
	}

	@Override
	public List<Contract> findAll() {
		return (List<Contract>) contractRepository.findAll();
	}

	@Override
	public Contract save(Contract contract) {
		return contractRepository.save(contract);
	}

	@Override
	public void deleteById(Long id) {
		contractRepository.deleteById(id);
	}

	}
