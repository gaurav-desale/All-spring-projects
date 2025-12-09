package com.ecommerce.ecom.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecom.Entity.CategoryEntity;
import com.ecommerce.ecom.Repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
	
	private final CategoryRepository repo;
	
	public CategoryController(CategoryRepository repo) {
		this.repo = repo;
	}

	@PostMapping
	public CategoryEntity create(@RequestBody CategoryEntity category) {
		return repo.save(category);
	}
	
	@GetMapping
	public List<CategoryEntity> getAll(){
		return repo.findAll();
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
	
	
	
}
