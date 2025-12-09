package com.ecommerce.ecom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecom.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity , Long>{
	
	List<ProductEntity> findByNameContaining(String name);
	List<ProductEntity> findByCategoryName(String categoryName);
	List<ProductEntity> findBySupplierName(String supplierName);

}
