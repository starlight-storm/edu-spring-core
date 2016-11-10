package com.example.api.v1;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.business.domain.Employee;
import com.example.business.service.EmployeeService;

import common.example.common.exception.EmployeeDeleteException;
import common.example.common.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	// Advance REST ClientでURLにhttp://localhost:8080/employees/{0|1}, GET
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // Spring4.3からは@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public Employee findById(@PathVariable int id) {
		Employee emp = employeeService.findById(id);
		if(emp == null) throw new EmployeeNotFoundException("そんな人はいません");
		return emp;
	}
	
	// Advance REST ClientでURLにhttp://localhost:8080/employees/{0|1}, DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // Spring4.3からは@DeleteMapping
	public Employee delete(@PathVariable int id) {
		throw new EmployeeDeleteException("消せません");
	}

	// Advance REST ClientでURLにhttp://localhost:8080/employees/, POST,
	// Data Formに入力データを設定（ex: name 斎藤, mail saito@sample.jp）
	@RequestMapping(method = POST) // Spring4.3からは@PostMapping
	public ResponseEntity<Employee> create(@Valid Employee emp, UriComponentsBuilder uriBuilder) {
		
		employeeService.create(emp);

        URI location = uriBuilder.path("employees/{id}")
                        .buildAndExpand(emp.getId())
                        .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>(
                emp, headers, HttpStatus.CREATED);
	}
	
	// エラーハンドラ
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    RestControllerError handleOrderException(EmployeeNotFoundException e) {
        return new RestControllerError(e.getMessage(), "http://localhost:8080/employees");
    }
}
