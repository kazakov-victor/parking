package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class VatrateDTO {
    private Long vatrate_id;
    private double percent;
    private String dtfrom;
    private String dtto;}
