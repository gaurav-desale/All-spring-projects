package com.empSystem.employee.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class DepartmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Long departmentId;
	private String departmentName;
	
	@OneToMany(mappedBy = "department")
	private List<EmployeeEntity>employee;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<EmployeeEntity> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeEntity> employee) {
		this.employee = employee;
	}
	
	

}
