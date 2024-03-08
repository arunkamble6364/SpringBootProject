package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Employee;
import com.main.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		
		 employee = employeeService.addEmployee(employee);
		 log.info("Save employee{}",employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> findAllEmployee(){
		List<Employee> employees = employeeService.findAllEmployee();
		
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmpByID(@PathVariable("id") Integer id){
		
		Employee employee  = employeeService.getEmpByID(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		employee = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Integer id){
		
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
