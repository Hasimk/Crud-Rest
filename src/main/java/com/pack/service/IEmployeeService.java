package com.pack.service;

import java.util.List;

import com.pack.model.Employee;

public interface IEmployeeService  {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);
	
	

}
