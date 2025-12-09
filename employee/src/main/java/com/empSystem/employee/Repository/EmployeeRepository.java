package com.empSystem.employee.Repository;

import com.empSystem.employee.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByEmployeeNameContaining(String employeeName);

    List<EmployeeEntity> findByDepartmentDepartmentName(String departmentName);

    List<EmployeeEntity> findByRoleRoleName(String roleName);
}

