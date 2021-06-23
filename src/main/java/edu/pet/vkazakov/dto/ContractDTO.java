package edu.pet.vkazakov.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContractDTO {
    private Long contract_id;
    private Long number;
    private Long person_id;
    private Double balance;
    private String dtfrom;
    private String dtto;
    private String note;
    private List<IncomeDTO> incomes;
    private List<PaymentDTO> payments;
}


