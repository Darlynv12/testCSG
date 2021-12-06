package com.test.company.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.company.entity.Department;
import com.test.company.service.DepartmentService;



@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	//create Department
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Department  department){
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(department));
	}
	
	//Read an Department
	@GetMapping("/{id}")
	public  ResponseEntity<?> read (@PathVariable Integer id){
		Optional<Department> oDepartment = departmentService.findBy(id);
		if(!oDepartment.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oDepartment);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Department department, @PathVariable Integer id){
		Optional<Department> oDepartment = departmentService.findBy(id);
		if(!oDepartment.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oDepartment.get().setName(department.getName());
		oDepartment.get().setLocation(department.getLocation());		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(oDepartment.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id){
		if(!departmentService.findBy(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		departmentService.deleteById(id);
		return ResponseEntity.ok().build(); 
	}
	
	@GetMapping
	public List<Department> listDepartments(){
		List<Department> departments =StreamSupport.stream(departmentService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return departments;
	}
	

}
