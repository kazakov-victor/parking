package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.InvoiceTrx;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceTrxRepository extends CrudRepository<InvoiceTrx, Long> {

	@Query(value = "SELECT i FROM InvoiceTrx i WHERE i.invoice_id LIKE '%' || :keyword || '%'")
	List<InvoiceTrx> search(@Param("keyword") String keyword);


}
