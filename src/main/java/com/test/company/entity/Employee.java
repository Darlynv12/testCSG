package com.test.company.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = -7437944246462946315L;
	
	@Id
	private Integer id;
	@Column(name="name", nullable = false, length = 25)
	private String name;
	@Column(name="salary", nullable = false)
	private Float salary;
	@Column(name = "depto_id", nullable = false)
	private Integer depto_id;
	
		
	public Employee() {
		super();
	}

	public Employee(Integer id, String name, Float salary, Integer depto_id) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.depto_id = depto_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Integer getDepto_id() {
		return depto_id;
	}


	public void setDepto_id(Integer depto_id) {
		this.depto_id = depto_id;
	}

}
