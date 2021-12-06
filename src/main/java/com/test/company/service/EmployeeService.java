package com.test.company.service;

import java.util.Optional;

import com.test.company.entity.Employee;


public interface EmployeeService {
	public Iterable<Employee> findAll();
	public Optional<Employee> findBy(Integer Id);
	public Employee save(Employee employee);
	public void deleteById(Integer Id);
}
