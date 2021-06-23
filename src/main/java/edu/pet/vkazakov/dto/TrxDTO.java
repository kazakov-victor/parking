package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class TrxDTO {
    private Long trx_id;
    private String sid_ledgertype;
    private String sid_trxtype;
    private Long period_id;
    private Long contract_id;
    private String ts;
    private String tscreate;
    private Double amount;
    private Long count;

}
