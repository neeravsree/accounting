package com.accounts.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.accounting.model.EmployeeRequest;
import com.accounts.accounting.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	

	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employeeRequest) throws Exception{
		
		employeeService.addEmployee(employeeRequest);
		return  new ResponseEntity<String>("Employee added successfully", HttpStatus.CREATED);
		
	}

}
