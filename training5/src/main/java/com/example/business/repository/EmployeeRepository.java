package com.example.business.repository;

import java.util.List;

import com.example.business.domain.Employee;

public interface EmployeeRepository {
	// 演習5 TODO: 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	List<Employee> findAll();
	
	// 演習5 TODO: 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	Employee findById(int id);
	
	// 演習5 TODO: 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	int create(Employee emp);
}
