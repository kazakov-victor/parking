package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class PeriodDTO {
    private Long period_id;
    private String dtfrom;
    private String dtto;
    private String tsclose;
    private boolean closed;


}
