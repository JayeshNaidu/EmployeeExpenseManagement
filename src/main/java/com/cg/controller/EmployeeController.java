package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService eService;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		return eService.addEmployee(employee);
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees(){
		return eService.getEmployees();
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int id) {
		return eService.getEmployeeById(id);
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		return eService.deleteEmployee(id);
	}
	
	@PostMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return eService.updateEmployee(employee);
	}
	
	@GetMapping("/getEmployeeByAll/{userName}/{password}/{role}")
	public Employee getEmployeeByAll(@PathVariable("userName") String userName, 
									 @PathVariable ("password") String password, 
									 @PathVariable("role") String role) {
		return eService.getEmployeeByAll(userName, password, role);
	}
}
 