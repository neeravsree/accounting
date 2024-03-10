package com.accounts.accounting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accounting.entity.Address;
import com.accounts.accounting.entity.Designation;
import com.accounts.accounting.entity.Employee;
import com.accounts.accounting.model.AddressRequest;
import com.accounts.accounting.model.EmployeeRequest;
import com.accounts.accounting.repo.AddressRepository;
import com.accounts.accounting.repo.DesignationRepository;
import com.accounts.accounting.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	DesignationRepository designationRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public void addEmployee(EmployeeRequest employeeRequest) throws Exception{
		
		Designation designation=Designation.builder().name(employeeRequest.getDesignation()).build();
		designation=designationRepository.save(designation);
		Employee employee=Employee.builder().designation(designation).firstName(employeeRequest.getFirstName())
				.lastName(employeeRequest.getLastName()).email(employeeRequest.getEmail()).build();
		List<AddressRequest> addressList=employeeRequest.getAddress();
		List<Address> address=addressList.stream().map(add->new Address(add.getAddressline1(),add.getAddressLine2(),add.getCity(),add.getPincode(),employee)).toList();
		
		employeeRepository.save(employee);
		addressRepository.saveAll(address);
	}
}
