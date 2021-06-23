package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.IncomeTypeDTO;
import edu.pet.vkazakov.entity.IncomeType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IncomeTypeMapper extends EntityMapper<IncomeTypeDTO, IncomeType> {
    @Mapping(source = "income_type_id", target = "incometype_id")
    IncomeTypeDTO toDto(IncomeType incomeType);
    @Mapping(source = "incometype_id", target = "income_type_id")
    @Mapping(target = "incomes", ignore = true)
    @Mapping(target = "prices", ignore = true)
     IncomeType toEntity(IncomeTypeDTO incomeTypeDTO);

}
