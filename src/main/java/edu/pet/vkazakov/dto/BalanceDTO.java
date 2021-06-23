package edu.pet.vkazakov.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BalanceDTO {
    private Long balance_id;
    private Long contract_id;
    private Long trx_id;
    private Date tsfrom;
    private Date tsto;
    private double balance;

}
