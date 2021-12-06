package com.test.company.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.company.entity.Employee;
import com.test.company.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional(readOnly =true)
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional(readOnly =true)
	public Optional<Employee> findBy(Integer Id) {
		return employeeRepository.findById(Id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(Integer Id) {
		employeeRepository.deleteById(Id);
		
	}

}
