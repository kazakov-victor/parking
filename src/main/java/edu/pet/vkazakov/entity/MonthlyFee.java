package edu.pet.vkazakov.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "monthly_fee")
@Entity

public class MonthlyFee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long monthly_fee_id;
//	@NotNull
	private Double fee;
	private Timestamp timeStart;
	private Timestamp timeFinish;


}


