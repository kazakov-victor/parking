package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.IncomeDTO;
import edu.pet.vkazakov.entity.Income;
import edu.pet.vkazakov.service.ContractService;
import edu.pet.vkazakov.service.IncomeTypeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses={DateMapper.class,
        IncomeTypeService.class, ContractService.class})
public interface IncomeMapper extends EntityMapper<IncomeDTO, Income> {
     @Mapping(target = "dtfrom", dateFormat = "yyyy-MM-dd")
     @Mapping(target = "dtto", dateFormat = "yyyy-MM-dd")
     @Mapping(source = "incomeType.income_type_id" , target = "incometype_id")
     @Mapping(source = "contract.contract_id" , target = "contract_id")
     IncomeDTO toDto(Income income);
    // @InheritInverseConfiguration
    @Mapping(source = "incometype_id" , target = "incomeType")
    @Mapping(source = "contract_id" , target = "contract")
     Income toEntity(IncomeDTO incomeDTO);
}


