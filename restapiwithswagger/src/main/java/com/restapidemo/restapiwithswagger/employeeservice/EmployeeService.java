package com.restapidemo.restapiwithswagger.employeeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapidemo.restapiwithswagger.employeeRepository.EmployeeRepository;
import com.restapidemo.restapiwithswagger.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	public Employee saveEmployee(Employee emp) {
		return empRepository.save(emp);
	}
	
	public List<Employee> saveAllEmployee(List<Employee> emp){
		return empRepository.saveAll(emp);
	}
	
	public Employee fetchEmployee(int id) {
		return empRepository.findById(id).get();
	}
	
	public List<Employee> fetchAllEmployee(){
		return empRepository.findAll();
	}
	
	public Employee updateEmpDetails(Employee emp) {
		Employee existingEmp = empRepository.findById(emp.getId()).orElse(null);
		existingEmp.setName(emp.getName());
		existingEmp.setDepartment(emp.getDepartment());
		existingEmp.setSalary(emp.getSalary());
		empRepository.save(existingEmp);
		return existingEmp;
	}
}
