package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.ChargeDTO;
import edu.pet.vkazakov.entity.Charge;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses={DateMapper.class})
public interface ChargeMapper extends EntityMapper<ChargeDTO, Charge> {

     @Mapping(source = "income_type_id" , target = "incometype_id")
     ChargeDTO toDto(Charge charge);
     @InheritInverseConfiguration
     Charge toEntity(ChargeDTO chargeDTO);
}


