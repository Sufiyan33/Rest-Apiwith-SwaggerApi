package com.restapidemo.restapiwithswagger.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapidemo.restapiwithswagger.employeeservice.EmployeeService;
import com.restapidemo.restapiwithswagger.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(description = "Added restEndpoint")
public class RestEndpoint {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addEmp")
	@ApiOperation(nickname = "AddEmployye", value = "Employee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp); 
	}
	
	@PostMapping("/addAllEmp")
	public List<Employee> addAllEmployee(@RequestBody List<Employee> emp){
		return empService.saveAllEmployee(emp);
	}
	
	@GetMapping("/emp/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empService.fetchEmployee(id);
	}
	
	@GetMapping("/allEmp")
	public List<Employee> getAllEmployee(){
		return empService.fetchAllEmployee();
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return empService.updateEmpDetails(emp);
	}
}