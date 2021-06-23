package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Long> {

	@Query(value = "SELECT pr.amount FROM Price pr WHERE pr.dtfrom <= ?1 " +
			"and (pr.dtto >= ?2 or pr.dtto is null) and pr.income_type_id = ?3", nativeQuery = true)
	double searchCurrentPrice(@Param("start") Date start, @Param("end") Date end, @Param("incometype") long incometype);

	@Query(value = "SELECT pr FROM Price pr WHERE pr.amount = ?1")
	List<Price> searchPriceByAmount(@Param("keyword") String keyword);

}
