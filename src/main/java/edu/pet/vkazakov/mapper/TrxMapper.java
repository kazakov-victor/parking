package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.TrxDTO;
import edu.pet.vkazakov.entity.Trx;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={TimestampMapper.class,
        TrxTypeMapper.class})
public interface TrxMapper extends EntityMapper<TrxDTO, Trx> {

     TrxDTO toDto(Trx trx);

     Trx toEntity(TrxDTO trxDTO);
}


