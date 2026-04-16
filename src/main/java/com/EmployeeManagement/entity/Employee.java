package com.EmployeeManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@NotBlank(message = "FIRSTNAME CANNOT BE EMPTY !")
	private String firstName;
	@Column(nullable = false)
	@NotBlank(message = "LASTNAME CANNOT BE EMPTY !")
	private String lastName;
	@Column(nullable = false, unique = true)
	@NotBlank(message = "EMAIL CANNOT BE EMPTY !")
	private String email;
	@Column(nullable = false)
	@NotBlank(message = "DEPARTMENT CANNOT BE EMPTY !")
	private String department;
	@Column(nullable = false)
	@Positive(message = "SALARY MUST BE POSITIVE !")
	private double salary;

}
