package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Charge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChargeRepository extends CrudRepository<Charge, Long> {

	@Query(value = "SELECT c FROM Charge c WHERE c.amount LIKE '%' || :keyword || '%'")
	List<Charge> search(@Param("keyword") String keyword);


}
