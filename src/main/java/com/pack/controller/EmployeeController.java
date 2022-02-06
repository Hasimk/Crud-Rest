package com.pack.controller;

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

import com.pack.model.Employee;
import com.pack.service.IEmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	// create employee Rest API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);

	}

	// get All Employee Rest Api
	@GetMapping()
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();

	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeid) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeid), HttpStatus.OK);

	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") long id , @RequestBody Employee employee ){
		return new ResponseEntity<Employee> (employeeService.updateEmployee(employee, id), HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		 employeeService.deleteEmployee(id);
		 
		 return new ResponseEntity<String>("Employee Deleted Successfully !", HttpStatus.OK );
		
		
		
		
	}

}
