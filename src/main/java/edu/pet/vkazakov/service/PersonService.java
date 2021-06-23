package edu.pet.vkazakov.service;

import edu.pet.vkazakov.entity.Person;

import java.util.List;

public interface PersonService {
	Person findById(Long id);
	List<Person> search(String keyword);
	List<Person> findAll();
	Person save(Person person);
	void deleteById(Long id);
}
