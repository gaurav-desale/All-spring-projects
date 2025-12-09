package com.empSystem.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empSystem.employee.Entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity , Long>{
	
	

}
