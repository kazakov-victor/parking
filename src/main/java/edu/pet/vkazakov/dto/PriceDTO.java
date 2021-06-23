package edu.pet.vkazakov.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class PriceDTO {
    private Long price_id;
    private Date dtfrom;
    private Date dtto;
    private double amount;
    private Long incometype_id;
}
