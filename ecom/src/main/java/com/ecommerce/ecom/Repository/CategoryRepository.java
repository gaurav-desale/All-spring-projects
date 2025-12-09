package com.ecommerce.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecom.Entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity , Long> {
	
	CategoryEntity findByName(String name);

}
