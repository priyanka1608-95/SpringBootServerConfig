package com.app.pojo;

import javax.persistence.*;


import lombok.Data;

@Data
@Entity
public class Employee
{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Integer id;
	
	private String name;
	
	private float salary;

	public Employee() {

	}
}
