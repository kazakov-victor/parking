package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Balance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BalanceRepository extends CrudRepository<Balance, Long> {
//TODO Расширить поиск на другие поля
	@Query(value = "SELECT b FROM Balance b WHERE b.balance LIKE '%' || :keyword || '%'")
	List<Balance> search(@Param("keyword") String keyword);


}
