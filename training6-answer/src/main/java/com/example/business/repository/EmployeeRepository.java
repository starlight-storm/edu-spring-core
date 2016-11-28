package com.example.business.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.business.domain.Employee;

public interface EmployeeRepository {
//  プロパティとカラム名が異なる場合
//	@Results({
//        @Result(property = "id", column = "EMP_ID"),
//        @Result(property = "name", column = "EMP_NAME"),
//        @Result(property = "mail", column = "EMP_MAIL")
//      })
	
	@Select("SELECT ID,NAME,MAIL FROM EMPLOYEE")
	List<Employee> findAll();
	
	@Select("SELECT * FROM EMPLOYEE WHERE ID = #{id}")
	Employee findById(int id);
	
	@Insert("INSERT INTO EMPLOYEE(NAME,MAIL) VALUES(#{name},#{mail})")
	int create(Employee emp);
}
