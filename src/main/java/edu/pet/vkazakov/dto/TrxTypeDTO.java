package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class TrxTypeDTO {
    private String sid;
    private String name;
    private String sid_ledgertype;
    private String optype;

}
