package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.PaymentType;
import org.springframework.data.repository.CrudRepository;

public interface PaymentTypeRepository extends CrudRepository<PaymentType, Long> {

/*
	@Query(value = "SELECT p FROM PaymentType p WHERE p.id LIKE '%' || :keyword || '%'")
	List<PaymentType> search(@Param("keyword") String keyword);
*/

	/*@Query(value = "SELECT id, name FROM PaymentType")
	List<PaymentType> list();*/


}
