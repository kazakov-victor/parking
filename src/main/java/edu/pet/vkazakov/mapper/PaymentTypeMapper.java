package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.PaymentTypeDTO;
import edu.pet.vkazakov.entity.PaymentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper extends EntityMapper<PaymentTypeDTO, PaymentType> {

     PaymentTypeDTO toDto(PaymentType paymentType);

     @Mapping(target = "payments", ignore = true)
     PaymentType toEntity(PaymentTypeDTO paymentTypeDTO);
}
