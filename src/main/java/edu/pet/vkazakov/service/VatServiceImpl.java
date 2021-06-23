package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Vat;
import edu.pet.vkazakov.repository.VatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class VatServiceImpl implements VatService {
	@Autowired
    VatRepository repository;

	public VatServiceImpl(VatRepository repository) {
		this.repository = repository;
	}

	@Override
	public Vat findById(Long id) {
		return repository.findById(id).orElse(new Vat());
	}

	@Override
	public List<Vat> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Vat> findAll() {
		return (List<Vat>) repository.findAll();
	}

	@Override
	public Vat save(Vat vat) {
		return repository.save(vat);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
