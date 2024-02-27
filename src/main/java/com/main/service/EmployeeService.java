package com.main.service;

import java.util.List;

import com.main.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> findAllEmployee();
	

}
