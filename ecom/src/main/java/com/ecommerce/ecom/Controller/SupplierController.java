package com.ecommerce.ecom.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecom.Entity.SupplierEntity;
import com.ecommerce.ecom.Repository.SupplierRepository;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierRepository repo;

    public SupplierController(SupplierRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public SupplierEntity create(@RequestBody SupplierEntity supplier) {
        return repo.save(supplier);
    }

    @GetMapping
    public List<SupplierEntity> getAll() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
