package com.ecommerce.ecom.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecom.Entity.ProductEntity;
import com.ecommerce.ecom.Repository.ProductRepository;

@RestController
@RequestMapping("/api/products")

public class ProductController {
	
	private final ProductRepository repo;
	
	public ProductController(ProductRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping
	public ProductEntity create(@RequestBody ProductEntity product) {
		return repo.save(product);
	}
	
	@GetMapping
	public List<ProductEntity> getAll(){
		return repo.findAll();
		}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/search")
	public List<ProductEntity> search(@RequestParam String name){
		return repo.findByNameContaining(name);
	}
	/*
	  @GetMapping("/{id}")
public Optional<ProductEntity> getById(@PathVariable Long id) {
    return repo.findById(id);
}
	  */

}
