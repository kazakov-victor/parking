package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class IncomeDTO {
    private Long income_id;
    private String dtfrom;
    private String dtto;
    private Double quantity;
    private Long incometype_id;
    private Long contract_id;

}
