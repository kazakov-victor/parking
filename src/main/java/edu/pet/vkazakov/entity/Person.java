package edu.pet.vkazakov.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString(exclude = "contracts")
@Data
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long person_id;
	//@NotNull
	private String surname;
	private String name;
	private String second_name;
	//@Size(min = 7)
	private String phone;
	private String address;
	@OneToMany(mappedBy = "person", cascade =
			{CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<Contract> contracts;

}


