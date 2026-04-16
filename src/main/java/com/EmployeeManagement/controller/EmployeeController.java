package com.EmployeeManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeController {
	
	private final EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.addEmployee(employee));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(service.getAllEmployees());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getEmployeeById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return ResponseEntity.ok(service.updateEmployee(id, employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return ResponseEntity.noContent().build();
		System.out.println("");
	}

}
