package com.example.customer.business.repository;

import java.util.List;

import com.example.customer.business.domain.Customer;

public interface CustomerRepository {
	// TODO 演習6 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	public List<Customer> findAll();

	// TODO 演習6 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	public Customer findById(int id);

	// TODO 演習6 動作するようにアノテーションを記述する Main.javaのTODOを見ながら、順番に進めること
	public void update(Customer customer);

}
