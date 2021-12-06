package com.test.company.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "department")
public class Department implements Serializable{


	private static final long serialVersionUID = -1999447084720208119L;
	
	@Id
	private Integer id;
	@Column(name="name", nullable = false, length = 25)
	private String name;
	@Column(name="location", nullable = false, length = 25)
	private String location;
	
	
	public Department() {
		super();
	}

	public Department(Integer id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
