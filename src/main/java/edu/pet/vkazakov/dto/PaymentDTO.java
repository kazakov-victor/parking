package edu.pet.vkazakov.dto;

import lombok.Data;

@Data
public class PaymentDTO {
	private Long payment_id;
	private Long contract_id;
	private String ts;
	private Double amount;
	private String note;
	private Long payment_type_id;
}


