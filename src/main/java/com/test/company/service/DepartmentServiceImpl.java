package com.test.company.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.company.entity.Department;
import com.test.company.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository deparmentRepository;

	@Override
	@Transactional(readOnly =true)
	public Iterable<Department> findAll() {
		return deparmentRepository.findAll();
	}

	@Override
	@Transactional(readOnly =true)
	public Optional<Department> findBy(Integer Id) {
		return deparmentRepository.findById(Id);
	}

	@Override
	@Transactional
	public Department save(Department deparment) {
		return deparmentRepository.save(deparment);
	}

	@Override
	@Transactional
	public void deleteById(Integer Id) {
		deparmentRepository.deleteById(Id);
	}

}
