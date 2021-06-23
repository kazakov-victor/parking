package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.TransferDTO;
import edu.pet.vkazakov.entity.Transfer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class})
public interface TransferMapper extends EntityMapper<TransferDTO, Transfer> {

    TransferDTO toDto(Transfer transfer);
     @InheritInverseConfiguration
     Transfer toEntity(TransferDTO transferDTO);
}


