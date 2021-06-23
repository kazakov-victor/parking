package edu.pet.vkazakov.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

//@Entity
// pay for rent place

public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rental_id;
	//@NotNull
	private Double pay;
	@DateTimeFormat(pattern= GlobalConstant.patternTime)
	private Timestamp timeStart;
	@DateTimeFormat(pattern= GlobalConstant.patternDate)
	private Timestamp timeFinish;


}


