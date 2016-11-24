package com.example.business.repository;

import java.util.List;

import com.example.business.domain.Employee;

public interface EmployeeRepository {
	//TODO 演習6 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	List<Employee> findAll();
	
	//TODO 演習6 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	Employee findById(int id);
	
	//TODO 演習6 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	int create(Employee emp);
}
