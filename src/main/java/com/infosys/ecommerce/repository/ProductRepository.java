package com.infosys.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//	Custom Finder Methods
	
//	find by name
	public List<Product> findByName (String name); 
	
//	find by price
	public List<Product> findByPrice(Integer price);
	
//	find product by category
	@Query("SELECT product FROM Product product WHERE product.category.name = :categoryName")
	public List<Product> findByCategoryName (String categoryName);
}