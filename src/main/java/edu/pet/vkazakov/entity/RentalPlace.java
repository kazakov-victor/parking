package edu.pet.vkazakov.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class RentalPlace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotNull
	private Integer number;
	private Boolean isFree;

	public RentalPlace() {}

	public RentalPlace(Integer number, Boolean isFree) {

		this.number = number;
		this.isFree = true;
	}

	 	public Long getId() {
		return id;
	}

		public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Boolean getFree() {
		return isFree;
	}

	public void setFree(Boolean free) {
		isFree = free;
	}
}


