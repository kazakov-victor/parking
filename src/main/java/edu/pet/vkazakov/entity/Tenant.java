package edu.pet.vkazakov.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity

public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tenant_id;
	//@NotNull
	private String surname;
	private String name;
	private String second_name;
	//@Size(min = 7)
	private String phone;
	private String address;




}
