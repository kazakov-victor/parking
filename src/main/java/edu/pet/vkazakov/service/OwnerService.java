package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Person;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
	Optional<Person> findById(Long id);
//	List<Person> search(String keyword);
	List<Person> findAll();
	Person save(Person person);
	void deleteById(Long id);
}
