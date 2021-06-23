package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Vatrate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VatrateRepository extends CrudRepository<Vatrate, Long> {

	@Query(value = "SELECT i FROM Vatrate i WHERE i.percent LIKE '%' || :keyword || '%'")
	List<Vatrate> search(@Param("keyword") String keyword);


}
