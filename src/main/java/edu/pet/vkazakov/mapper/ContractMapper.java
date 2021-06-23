package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.ContractDTO;
import edu.pet.vkazakov.entity.Contract;
import edu.pet.vkazakov.service.PersonService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DateMapper.class, PersonMapper.class,
        IncomeMapper.class, PersonService.class})
public interface ContractMapper extends EntityMapper<ContractDTO, Contract> {

    @Mapping(source = "person.person_id", target = "person_id")
    @Mapping(target = "payments", ignore = true)
   // @Mapping(source = "incomes", target = "incomeDTOS")
    ContractDTO toDto(Contract contract);

   // @InheritInverseConfiguration
   @Mapping(source = "person_id", target = "person")
   @Mapping(target = "incomes", ignore = true)
   @Mapping(target = "payments", ignore = true)
    Contract toEntity(ContractDTO contractDTO);

}
