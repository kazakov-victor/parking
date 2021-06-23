package edu.pet.vkazakov.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity

public class Garage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotNull
	private Integer number;

	public Garage() {}

	public Garage(Integer number) {

		this.number = number;

	}

	public Garage(Long id, Integer number ) {
		this.id = id;
		this.number = number;
		}

	 	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}





}


