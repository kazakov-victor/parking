package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

	@Query(value = "SELECT i FROM Invoice i WHERE i.payed LIKE '%' || :keyword || '%'")
	List<Invoice> search(@Param("keyword") String keyword);


}
