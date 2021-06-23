package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

	@Query(value = "SELECT p FROM Person p WHERE upper(p.surname) LIKE upper('%'|| :keyword ||'%')" +
			" OR p.phone LIKE '%' || :keyword || '%'")
	List<Person> search(@Param("keyword") String keyword);


}
