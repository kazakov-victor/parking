package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.PaymentDTO;
import edu.pet.vkazakov.entity.Payment;
import edu.pet.vkazakov.service.ContractService;
import edu.pet.vkazakov.service.PaymentTypeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//
@Mapper(componentModel = "spring", uses = {TimestampMapper.class,
        PaymentTypeMapper.class, ContractService.class, PaymentTypeService.class })
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment> {
    @Mapping(target = "ts", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "payment_type_id", source = "paymentType.payment_type_id")
    @Mapping(target = "contract_id", source = "contract.contract_id")
    PaymentDTO toDto(Payment payment);

     //@InheritInverseConfiguration
     @Mapping(target = "paymentType", source = "payment_type_id")
     @Mapping(target = "tscreate", ignore = true)
     @Mapping(target = "tsagent", ignore = true)
     @Mapping(target = "period_id", ignore = true)
     @Mapping(target = "contract", source = "contract_id")
    Payment toEntity(PaymentDTO paymentDTO);

}
