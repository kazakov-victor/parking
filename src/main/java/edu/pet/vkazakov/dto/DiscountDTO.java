package edu.pet.vkazakov.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DiscountDTO {
    private Long discount_id;
    private Long contract_id;
    private Long period_id;
    private Long charge_id;
    private Long trx_id;
    private Long revoke_id;
    private Long revokedby_id;
    private Timestamp ts;
    private Timestamp tscreate;
    private double amount;

}
