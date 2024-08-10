package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/emps")
	public String wish() {
		
		return "Hie...,Welcome to SpringBoot" ;
	}
	
	@PostMapping("/reg")
	public String registerEmployee(@RequestBody EmployeeInfo employee) {
	String empInfo = employeeService.registerEmployee(employee);
		
		return empInfo;
	}
	
	@GetMapping("/{empId}")
	public Optional<EmployeeInfo> getEmployeeByEmpId(@PathVariable Long empId) {
	Optional<EmployeeInfo> fetchedEmployee = employeeService.getEmployeeByEmpId(empId);
		
		return fetchedEmployee;
	}
	
	@PutMapping("/{empId}")
	public EmployeeInfo updateEmployee(@PathVariable Long empId, @RequestBody EmployeeInfo employee) {
	EmployeeInfo updatedEmployee = employeeService.updateEmployeeByEmpId(empId, employee);
		
		return updatedEmployee;
	}
	
		
}
