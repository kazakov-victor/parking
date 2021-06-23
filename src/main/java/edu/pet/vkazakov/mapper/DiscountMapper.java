package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.DiscountDTO;
import edu.pet.vkazakov.entity.Discount;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class })
public interface DiscountMapper extends EntityMapper<DiscountDTO, Discount> {

     DiscountDTO toDto(Discount discount);
     @InheritInverseConfiguration
     Discount toEntity(DiscountDTO discountDTO);
}


