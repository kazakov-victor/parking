package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class InvoiceDTO {
    private Long invoice_id;
    private  Long contract_id;
    private Long pid_period;
    private String dt;
    private String dtcreate;
    private boolean payed;

}
