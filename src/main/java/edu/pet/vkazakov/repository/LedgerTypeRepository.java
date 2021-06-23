package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.LedgerType;
import org.springframework.data.repository.CrudRepository;

public interface LedgerTypeRepository extends CrudRepository<LedgerType, Long> {

/*
	@Query(value = "SELECT l FROM LedgerType l WHERE l.name LIKE '%' || :keyword || '%'")
	List<LedgerType> search(@Param("keyword") String keyword);
*/


}
