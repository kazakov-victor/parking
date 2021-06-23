package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class TransferDTO {
    private Long transfer_id;
    private Long period_id;
    private Long contract_from_id;
    private Long contract_to_id;
    private Long trx_from_id;
    private Long trx_to_id;
    private Long revoke_id;
    private Long revokedby_id;
    private String ts;
    private String tscreate;
    private double amount;
    private String note;

}
