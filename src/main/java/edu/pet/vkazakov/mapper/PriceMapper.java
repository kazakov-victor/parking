package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.PriceDTO;
import edu.pet.vkazakov.entity.Price;
import edu.pet.vkazakov.service.IncomeTypeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses={DateMapper.class, IncomeTypeService.class})
public interface PriceMapper extends EntityMapper<PriceDTO, Price> {
     @Mapping(target = "dtfrom", dateFormat = "yyyy-MM-dd")
     @Mapping(target = "dtto", dateFormat = "yyyy-MM-dd")
     @Mapping(target = "incometype_id", source = "incomeType.income_type_id")
     PriceDTO toDto(Price price);
     @Mapping(target = "incomeType", source = "incometype_id")
     Price toEntity(PriceDTO priceDTO);
}


