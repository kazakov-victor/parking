package edu.pet.vkazakov.repository;


import edu.pet.vkazakov.entity.Period;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public interface PeriodRepository extends CrudRepository<Period, Long> {

	@Query(value = "select p from Period p where p.closed=false and p.dtto < current_date")
	ArrayList<Period> searchOpenPeriod();//@Param("keyword") String keyword);
	@Query(value = "select p from Period p where ?1 between p.dtfrom and p.dtto")
	Period findByDate(@Param("date") Date date);
	@Query(value = "select period_id from Period p where p.dtfrom = ?1", nativeQuery = true)
	Optional<Long> findByDtfrom(@Param("date") Date date);


}
