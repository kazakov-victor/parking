package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Saldo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;


public interface SaldoRepository extends CrudRepository<Saldo, Long> {

	@Query(value = "SELECT * FROM saldo WHERE saldo.period_id = (select id from period where dtfrom = ?)", nativeQuery = true)
	List<Saldo> search(@Param("sqlData") Date sqlData);

}