package com.empSystem.employee.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empSystem.employee.Entity.DepartmentEntity;
import com.empSystem.employee.Repository.DepartmentRepository;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private final DepartmentRepository departmentRepository ;
	
	
	public DepartmentController(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	@PostMapping
	public DepartmentEntity addDepartment(@RequestBody DepartmentEntity department) {
		return departmentRepository.save(department);
	}
	
	@GetMapping
	public List<DepartmentEntity> getAllDepartment(){
		return departmentRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Long id) {
		departmentRepository.deleteById(id);
	}
	
	
}
