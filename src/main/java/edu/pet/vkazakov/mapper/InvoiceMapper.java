package edu.pet.vkazakov.mapper;

import edu.pet.vkazakov.dto.InvoiceDTO;
import edu.pet.vkazakov.entity.Invoice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={DateMapper.class})
public interface InvoiceMapper extends EntityMapper<InvoiceDTO, Invoice> {

   //  @Mapping(source = "invoiceType" , target = "invoiceTypeDTO")
     InvoiceDTO toDto(Invoice invoice);
     @InheritInverseConfiguration
     Invoice toEntity(InvoiceDTO invoiceDTO);
}


