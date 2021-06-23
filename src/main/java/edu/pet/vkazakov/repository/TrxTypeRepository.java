package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.TrxType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrxTypeRepository extends CrudRepository<TrxType, Long> {

	@Query(value = "SELECT t FROM Trx t WHERE t.amount LIKE '%' || :keyword || '%'")
	List<TrxType> search(@Param("keyword") String keyword);


}
