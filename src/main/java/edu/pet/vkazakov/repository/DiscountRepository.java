package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Discount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscountRepository extends CrudRepository<Discount, Long> {

	@Query(value = "SELECT c FROM Discount c WHERE c.amount LIKE '%' || :keyword || '%'")
	List<Discount> search(@Param("keyword") String keyword);


}
