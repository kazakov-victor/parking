package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class SaldoDTO {
    private Long saldo_id;
    private Long contract_id;
    private Long period_id;
    private double debet;
    private double credit;
    private double openingbalance;
    private double closingbalance;

}

