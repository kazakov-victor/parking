package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Vat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VatRepository extends CrudRepository<Vat, Long> {

	@Query(value = "SELECT v FROM Vat v WHERE v.amount LIKE '%' || :keyword || '%'")
	List<Vat> search(@Param("keyword") String keyword);


}
