package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Person;
import edu.pet.vkazakov.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired
    PersonRepository repository;

	public PersonServiceImpl(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public Person findById(Long id) {
		return repository.findById(id).orElse(new Person());
	}

	@Override
	public List<Person> search(String keyword) {
		return repository.search(keyword);
	}



	@Override
	public List<Person> findAll() {
		return (List<Person>) repository.findAll();
	}

	@Override
	public Person save(Person person) {
		return repository.save(person);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	}
