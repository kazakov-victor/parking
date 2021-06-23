package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.VatDTO;
import edu.pet.vkazakov.entity.Vat;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={TimestampMapper.class})
public interface VatMapper extends EntityMapper<VatDTO, Vat> {

     // @Mapping(source = "vat" , target = "vatDTO")
     VatDTO toDto(Vat vat);
     @InheritInverseConfiguration
     Vat toEntity(VatDTO vatDTO);
}


