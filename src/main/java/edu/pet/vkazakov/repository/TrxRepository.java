package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Trx;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrxRepository extends CrudRepository<Trx, Long> {

	@Query(value = "SELECT t FROM Trx t WHERE t.amount LIKE '%' || :keyword || '%'")
	List<Trx> search(@Param("keyword") String keyword);


}
