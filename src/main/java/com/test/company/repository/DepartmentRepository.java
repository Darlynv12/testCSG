package com.test.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.company.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
