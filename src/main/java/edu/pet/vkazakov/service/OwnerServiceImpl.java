package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Person;
import edu.pet.vkazakov.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class OwnerServiceImpl implements OwnerService {
	@Autowired
    OwnerRepository repository;

	public OwnerServiceImpl(OwnerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Person> findById(Long id) {
		return repository.findById(id);
	}

/*
	@Override
	public List<Person> search(String keyword) {
		return repository.search(keyword);
	}
*/

	@Override
	public List<Person> findAll() {
		return (List<Person>) repository.findAll();
	}

	@Override
	public Person save(Person person) {

		// Save the entity to the repository
		return repository.save(person);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
