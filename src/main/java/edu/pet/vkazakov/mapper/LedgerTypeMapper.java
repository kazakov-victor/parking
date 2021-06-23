package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.LedgerTypeDTO;
import edu.pet.vkazakov.entity.LedgerType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class })
public interface LedgerTypeMapper extends EntityMapper<LedgerTypeDTO, LedgerType> {

     // @Mapping(source = "ledgerType" , target = "ledgerTypeDTO")
     LedgerTypeDTO toDto(LedgerType ledgerType);
     @InheritInverseConfiguration
     LedgerType toEntity(LedgerTypeDTO ledgerTypeDTO);
}


