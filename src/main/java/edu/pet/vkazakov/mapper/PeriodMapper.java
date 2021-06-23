package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.PeriodDTO;
import edu.pet.vkazakov.entity.Period;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class,
        TimestampMapper.class})
public interface PeriodMapper extends EntityMapper<PeriodDTO, Period> {

   //  @Mapping(source = "" , target = "")
     PeriodDTO toDto(Period period);
     @InheritInverseConfiguration
     Period toEntity(PeriodDTO periodDTO);
}


