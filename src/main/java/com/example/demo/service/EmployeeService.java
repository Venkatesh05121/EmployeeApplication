package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.repository.EmployeeRepository;

import ch.qos.logback.classic.Logger;

@Service
public class EmployeeService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	EmployeeRepository employeeRepository;
	
	public String registerEmployee(EmployeeInfo employee) {
	EmployeeInfo empInfo = employeeRepository.save(employee);
		
		return "Your Employee Registration Created Successfully ! " +empInfo.getName();
	}
	
	public Optional<EmployeeInfo> getEmployeeByEmpId(Long empId) {
	Optional<EmployeeInfo> fetchedEmployee = employeeRepository.findById(empId);
	logger.info("Employee data fetched Successfully... : {} " , fetchedEmployee.toString());
		
		return fetchedEmployee;
	}
	
	public EmployeeInfo updateEmployeeByEmpId(Long empId, EmployeeInfo employee) {
	EmployeeInfo updatedEmp = employeeRepository.findById(empId).orElse(null);
		if(updatedEmp != null) {
			updatedEmp.setName(employee.getName());
			updatedEmp.setEmail(employee.getEmail());
			updatedEmp.setGender(employee.getGender());
			updatedEmp.setSalary(employee.getSalary());
			updatedEmp.setContact(employee.getContact());
			
		EmployeeInfo empInfo = employeeRepository.save(updatedEmp);
		logger.info("Employee Data Was Updated Successfully : {} " , empInfo.getName());
		return empInfo;
			
		}
		
		return null;  //if the existing data is not found it returns null
	}

}
