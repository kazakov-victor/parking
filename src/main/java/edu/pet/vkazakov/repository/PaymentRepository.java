package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

/*	@Query(value = "SELECT p FROM Payment p WHERE p.amount LIKE '%' || :keyword || '%'")
	List<Payment> search(@Param("keyword") String keyword);*/
	@Query(value = "SELECT sum(amount) FROM Payment p WHERE p.contract_id = ?1" +
			" and p.period_id = ?2", nativeQuery = true)
	Double sumByContractIdAndPeriod(@Param("contract_id") Long contract_id,
										   @Param("period_id") Long period_id);


}
