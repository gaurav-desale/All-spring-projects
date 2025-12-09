package com.ecommerce.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecom.Entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity , Long>{
	
	SupplierEntity findByName(String name); 

}
