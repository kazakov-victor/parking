package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.VatrateDTO;
import edu.pet.vkazakov.entity.Vatrate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class})
public interface VatrateMapper extends EntityMapper<VatrateDTO, Vatrate> {

     VatrateDTO toDto(Vatrate vatrate);
     @InheritInverseConfiguration
     Vatrate toEntity(VatrateDTO vatrateDTO);
}


