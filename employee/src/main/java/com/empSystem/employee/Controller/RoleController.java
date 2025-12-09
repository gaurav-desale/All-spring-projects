package com.empSystem.employee.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empSystem.employee.Entity.RoleEntity;
import com.empSystem.employee.Repository.RoleRepository;

@RestController
@RequestMapping("/api/roles")
public class RoleController{

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping
    public RoleEntity addRole(@RequestBody RoleEntity role) {
        return roleRepository.save(role);
    }

    @GetMapping
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }
}
