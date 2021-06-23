package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.SaldoDTO;
import edu.pet.vkazakov.entity.Saldo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class})
public interface SaldoMapper extends EntityMapper<SaldoDTO, Saldo> {


     SaldoDTO toDto(Saldo saldo);
     @InheritInverseConfiguration
     Saldo toEntity(SaldoDTO saldoDTO);
}


