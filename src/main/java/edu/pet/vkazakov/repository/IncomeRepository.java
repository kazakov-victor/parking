package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Income;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


public interface IncomeRepository extends CrudRepository<Income, Long> {

	@Query(value = "SELECT * FROM income WHERE income.name = ?", nativeQuery = true)
	Optional<Income> findByName(@Param("name") String name);

	@Query(value = "SELECT * FROM income WHERE income.contract_id = ?1 and income.dtfrom < ?2" +
			" and (income.dtto > ?3 or income.dtto is null)", nativeQuery = true)
	List<Income> searchByContractByPeriod(@Param("contract_id") Long contract_id,
										  @Param("start") Date start,
										  @Param("end") Date end);

	@Query(value = "SELECT * FROM income inner join income_type ON income.income_type_id = income_type.income_type_id WHERE income.contract_id = ?1 and income.dtfrom < ?2" +
			" and (income.dtto > ?3 or income.dtto is null) and income_type.basis = ?4", nativeQuery = true)
	List<Income> searchByContractByPeriodByBasis(@Param("contract_id") Long contract_id,
												 @Param("start") Date start,
												 @Param("end") Date end,
												 @Param("basis") String basis);

}