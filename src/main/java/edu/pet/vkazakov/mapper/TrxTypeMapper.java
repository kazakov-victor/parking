package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.TrxTypeDTO;
import edu.pet.vkazakov.entity.TrxType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class})
public interface TrxTypeMapper extends EntityMapper<TrxTypeDTO, TrxType> {

     //@Mapping(source = "trxTypeType" , target = "trxTypeTypeDTO")
     TrxTypeDTO toDto(TrxType trxType);
     @InheritInverseConfiguration
     TrxType toEntity(TrxTypeDTO trxTypeDTO);
}


