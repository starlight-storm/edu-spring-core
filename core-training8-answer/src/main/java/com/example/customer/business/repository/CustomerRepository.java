package com.example.customer.business.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.customer.business.domain.Customer;

@Mapper
public interface CustomerRepository {
	// もし、プロパティとカラム名が異なる場合
	// @Results({
	// @Result(property = "id", column = "EMP_ID"),
	// @Result(property = "name", column = "EMP_NAME"),
	// @Result(property = "mail", column = "EMP_MAIL")
	// })

	@Select("SELECT ID, NAME, ADDRESS, EMAIL_ADDRESS FROM CUSTOMER")
	public List<Customer> findAll();

	@Select("SELECT * FROM CUSTOMER WHERE ID = #{id}")
	public Customer findById(int id);

	@Update("UPDATE CUSTOMER SET NAME=#{name}, ADDRESS=#{address}, EMAIL_ADDRESS=#{emailAddress} WHERE ID = #{id}")
	public void update(Customer customer);

}
