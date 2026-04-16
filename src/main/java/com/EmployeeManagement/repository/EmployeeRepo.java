package com.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagement.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
