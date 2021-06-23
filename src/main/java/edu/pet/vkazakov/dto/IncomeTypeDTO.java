package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class IncomeTypeDTO {
    private Long incometype_id;
    private String name;
    private String note;
    private String basis;
}
