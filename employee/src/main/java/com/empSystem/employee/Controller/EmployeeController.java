package com.empSystem.employee.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empSystem.employee.Entity.EmployeeEntity;
import com.empSystem.employee.Repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@PostMapping
	public EmployeeEntity addemployee(@RequestBody EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping
	public List<EmployeeEntity> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}
	
}
