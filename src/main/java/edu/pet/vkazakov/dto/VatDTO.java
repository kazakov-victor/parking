package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class VatDTO {
    private Long vat_id;
    private Long vatrate_id;
    private Long charge_id;
    private Long trx_id;
    private Long period_id;
    private Long revoke_id;
    private Long revokedby_id;
    private String ts;
    private String tscreate;
    private double amount;
}