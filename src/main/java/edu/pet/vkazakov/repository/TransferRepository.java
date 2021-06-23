package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Transfer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferRepository extends CrudRepository<Transfer, Long> {

	@Query(value = "SELECT t FROM Transfer t WHERE t.amount LIKE '%' || :keyword || '%'")
	List<Transfer> search(@Param("keyword") String keyword);


}
