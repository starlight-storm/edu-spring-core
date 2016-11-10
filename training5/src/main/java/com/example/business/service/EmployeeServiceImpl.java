package com.example.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.business.domain.Employee;
import com.example.business.repository.EmployeeRepository;

@Service("employeeService")
//演習5 TODO: トランザクションのためのアノテーションを記述する
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public int create(Employee emp) {
		return employeeRepository.create(emp);
	}
}