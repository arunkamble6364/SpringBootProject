package com.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Employee;
import com.main.exception.custom_exception.EmptyInputException;
import com.main.repository.EmployeeRepository;
import com.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getName().isEmpty() || employee.getName().length()==0) {
			throw new EmptyInputException("601","input field is empty");
		}
		
		 employee = employeeRepository.save(employee);
		return employee;
	}

	@Override
	public List<Employee> findAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee2 = employeeRepository.save(employee);
		return employee2;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		
		employeeRepository.deleteById(id);
		
		
	}

	@Override
	public Employee getEmpByID(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
		
	}

}
