package com.empSystem.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empSystem.employee.Entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity , Long>{

}
