package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class ChargeDTO {
    private Long charge_id;
    private Long contract_id;
    private Long period_id;
    private Long incometype_id;
    private double amount;
    private Long count;

  /*  private Long trx_id;
    private Long revoke_id;
    private Long revokedby_id;
    private boolean vatincluded;
    private Timestamp ts;
    private Timestamp tscreate;

    private String note;*/

}
