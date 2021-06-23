package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Person;
import org.springframework.data.repository.CrudRepository;


public interface OwnerRepository extends CrudRepository<Person, Long> {

	/*@Query(value = "SELECT o FROM Person o WHERE o.surname LIKE '%' || :keyword || '%'"
			+ " OR o.name LIKE '%' || :keyword || '%'"
			+ " OR o.second_name LIKE '%' || :keyword || '%'"
			+ " OR o.phone LIKE '%' || :keyword || '%'"
			+ " OR o.address LIKE '%' || :keyword || '%'")
	List<Person> search(@Param("keyword") String keyword);*/
}
