package com.accounts.accounting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.accounting.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
