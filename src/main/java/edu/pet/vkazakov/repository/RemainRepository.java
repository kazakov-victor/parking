package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Remain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RemainRepository extends CrudRepository<Remain, Long> {

	@Query(value = "SELECT r FROM Remain r WHERE r.note LIKE '%' || :keyword || '%'")
	List<Remain> search(@Param("keyword") String keyword);


}
