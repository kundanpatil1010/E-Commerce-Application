package com.infosys.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.ecommerce.model.Product;
import com.infosys.ecommerce.serviceimplementation.ProductServiceImp;

@RestController
@CrossOrigin ("http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductServiceImp service;
	
//	Swagger API url
//	http://localhost:8080/swagger-ui/index.html
	
//	save product
	@PostMapping ("/product/{categoryId}")
	public Product saveproduct (@RequestBody Product product, @PathVariable int categoryId) {
		return service.saveProduct(product, categoryId);
	}
	
//	update product
	@PutMapping("/product/{productId}/{categoryId}")
	public Product updateProduct(@RequestBody Product product, @PathVariable int productId,@PathVariable int categoryId) {
		return service.updateProduct(product, productId, categoryId);
	}
	
//	get all products
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return service.getAllProduct();
	}
	
//	get product by id
	@GetMapping("/product/{id}")
	public Product getProductById (@PathVariable int id) {
		return service.getProductById(id);
	}
	
//	delete product
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
//===================={ Custom Finder Methods }====================
	
//	find product by name
	@GetMapping("/product/name/{name}")
	public List<Product> findProductByName(@PathVariable String name){
		return service.findByName(name);
	}
	
//	find product by price
	@GetMapping("/product/price/{price}")
	public List<Product> findProductByPrice(@PathVariable Integer price){
		return service.findByPrice(price);
	}
	
//	find product by category name
	@GetMapping("/product/category-name/{categoryName}")
	public List<Product> findByCategoryName(@PathVariable String categoryName) {
		return service.findByCategoryName(categoryName);
	}
}