package edu.pet.vkazakov.repository;
/*
import edu.pet.entity.Tenant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TenantRepository extends CrudRepository<Tenant, Long> {

	@Query(value = "SELECT t FROM Tenant t WHERE t.surname LIKE '%' || :keyword || '%'"
			+ " OR t.name LIKE '%' || :keyword || '%'"
			+ " OR t.second_name LIKE '%' || :keyword || '%'"
			+ " OR t.phone LIKE '%' || :keyword || '%'"
			+ " OR t.address LIKE '%' || :keyword || '%'")
	List<Tenant> search(@Param("keyword") String keyword);
}


 */