package com.infosys.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.infosys.ecommerce.model.Product;

public interface ProductService {
	
//	save product
	public Product saveProduct (Product product, int categoryId);
	
//	update product
	public Product updateProduct (Product product, int productId, int categoryId);
	
//	get all products
	public List<Product> getAllProduct();
	
//	get product by id
	public Product getProductById(int id);
	
//	delete product
	public String deleteProduct(int id);
	
//======={ Custom finder methods }=======
	
//	find product by name
	public List<Product> findByName (String name);
	
//	find product by price
	public List<Product> findByPrice (Integer price);
	
//	find product by category name
	public List<Product> findByCategoryName (String categoryName);
	
//======={ Pagination code }=======
	
	Page<Product> findPaginated (int pageNo, int pageSize, String sortField, String sortDir);
}