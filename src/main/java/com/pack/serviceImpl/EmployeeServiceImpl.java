package com.pack.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.exception.ResourceNotFoundException;
import com.pack.model.Employee;
import com.pack.repository.EmployeeRepository;
import com.pack.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired

	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		/*
		 * Optional<Employee> employee = employeeRepository.findById(id); if
		 * (employee.isPresent()) {
		 * 
		 * return employee.get(); } else {
		 * 
		 * throw new ResourceNotFoundException("Employee", "Id", id); }
		 */
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//we need to check wheather employee with given id is persent in db or not
		Employee exitingEmployee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		exitingEmployee.setEmail(employee.getEmail());
		exitingEmployee.setFirstName(employee.getFirstName());
		exitingEmployee.setLastName(employee.getLastName());
		employeeRepository.save(exitingEmployee);
		return exitingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
		

	}

}
