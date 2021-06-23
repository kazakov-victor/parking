package edu.pet.vkazakov.repository;

import edu.pet.vkazakov.entity.Contract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Long> {
    @Query(value = "select contract_id from contract where contract.dtfrom between ?1 and ?2 " +
            "or contract.dtfrom < ?1 and contract.dtto is null",
            nativeQuery = true)
    List<Long> searchByPeriod(@Param("start") Date start, @Param("end") Date end);

}
