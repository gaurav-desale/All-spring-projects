package com.Product_.Managemen_System.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@PostMapping
	public String createProduct(@RequestBody ProductEntity product) {
		productRepository.save(product);
		return "Product inserted successfully!";
	}
	
	@GetMapping
	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/{productId}")
	public Optional<ProductEntity> getProductById(@PathVariable Long productId) {
		return productRepository.findById(productId);
	}
	
	@PutMapping("/{productId}")
	public String updateProduct(@RequestBody ProductEntity product, @PathVariable Long productId) {
		product.setProductId(productId);
		productRepository.save(product);
		return "Product updated successfully!";
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		productRepository.deleteById(productId);
		return "Product deleted successfully!";
	}
}
