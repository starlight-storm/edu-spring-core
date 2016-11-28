package com.example.business.service;

import java.util.List;

import com.example.business.domain.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(int id);
	int create(Employee emp);
}