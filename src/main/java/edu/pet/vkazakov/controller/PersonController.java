package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.dto.PersonDTO;
import edu.pet.vkazakov.entity.Person;
import edu.pet.vkazakov.mapper.PersonMapper;
import edu.pet.vkazakov.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class PersonController {
	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}

	@Autowired
	PersonService personService;
	@Autowired
	PersonMapper personMapper;

	@GetMapping("/list")
	public List<PersonDTO> listPerson() {
		List<Person> persons = personService.findAll();
		List<PersonDTO> personDTOS = personMapper.toDto(persons);
		return personDTOS;
	}

	@RequestMapping("/save")
	public String savePerson(@RequestBody PersonDTO personDTO) {
		Person person = personMapper.toEntity(personDTO);
		//TODO добавить обработку исключений?
		personService.save(person);
		return "/persons/list";
	}

	@RequestMapping("/edit/{id}")
	public PersonDTO editPerson(@PathVariable("id") Long id) {
		Person person = personService.findById(id);
		PersonDTO personDTO = personMapper.toDto(person);
		return personDTO;
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePerson(@PathVariable("id") Long id) {
		personService.deleteById(id);
		return "/persons/list";
	}
	
	@RequestMapping("/search")
	public List<PersonDTO> search(@RequestParam(name = "keyword", required = false) String keyword) {
		List<Person> persons;
		if(equals(keyword, "all") || keyword == null){
			persons = personService.findAll();
		}
		else {persons = personService.search(keyword);}

		List<PersonDTO> personDTOS = personMapper.toDto(persons);
		return personDTOS;
	}	
}


