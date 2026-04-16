package com.EmployeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.exception.EmployeeNotFoundException;
import com.EmployeeManagement.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	private final EmployeeRepo repo;
	
	public EmployeeService(EmployeeRepo repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	
	public Employee addEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	public Employee getEmployeeById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
	}
	
	public void deleteEmployee(Long id) {
		Employee e = repo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(
						"Employee not found with id: "+id));
		repo.delete(e);
	}
	
	public Employee updateEmployee(Long id, Employee employee) {
		Employee e = repo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(
						"Employee not found with id: "+id));
		
		e.setFirstName(employee.getFirstName());
		e.setLastName(employee.getLastName());
		e.setEmail(employee.getEmail());
		e.setDepartment(employee.getDepartment());
		e.setSalary(employee.getSalary());
		
		return repo.save(e);
	}
}
