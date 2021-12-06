package com.test.company.controller;

import java.util.List;
import java.util.Optional;
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

import com.test.company.entity.Employee;
import com.test.company.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//create Employee
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Employee employee){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
	}
	
	//Read an Employee
	@GetMapping("/{id}")
	public  ResponseEntity<?> read (@PathVariable Integer id){
		Optional<Employee> oEmployee = employeeService.findBy(id);
		
		if(!oEmployee.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(oEmployee);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Employee employee, @PathVariable Integer id){
		Optional<Employee> oEmployee = employeeService.findBy(id);
		if(!oEmployee.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oEmployee.get().setName(employee.getName());
		oEmployee.get().setSalary(employee.getSalary());	
		oEmployee.get().setDepto_id(employee.getDepto_id());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(oEmployee.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id){
		if(!employeeService.findBy(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		employeeService.deleteById(id);
		return ResponseEntity.ok().build(); 
	}
	
	@GetMapping
	public List<Employee> listEmployees(){
		List<Employee> employees =StreamSupport.stream(employeeService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return employees;
	}
}
