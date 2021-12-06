package com.test.company.service;


import java.util.Optional;

import com.test.company.entity.Department;

public interface DepartmentService {
	public Iterable<Department> findAll();
	public Optional<Department> findBy(Integer Id);
	public Department save(Department deparment);
	public void deleteById(Integer Id);
}
