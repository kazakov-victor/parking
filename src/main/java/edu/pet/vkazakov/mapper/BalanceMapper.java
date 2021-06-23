package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.BalanceDTO;
import edu.pet.vkazakov.entity.Balance;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class})
public interface BalanceMapper extends EntityMapper<BalanceDTO, Balance> {

    // @Mapping(source = "balance" , target = "balanceDTO")
     BalanceDTO toDto(Balance balance);
     @InheritInverseConfiguration
     Balance toEntity(BalanceDTO balanceDTO);
}


