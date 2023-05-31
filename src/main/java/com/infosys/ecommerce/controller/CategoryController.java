package com.infosys.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.ecommerce.model.Category;
import com.infosys.ecommerce.serviceimplementation.CategoryServiceImp;

@RestController
@CrossOrigin ("http://localhost:3000")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImp service;
	
//	save category
	@PostMapping("/category")
	public Category saveCategory (@RequestBody Category category) {
		return service.saveCategory(category);
	}
	
//	update category
	public Category updateCategory (@RequestBody Category category, @PathVariable int id) {
		return service.updateCategory(category, id);
	}
	
//	get all categories
	@GetMapping("/categories")
	public List<Category> getAllCategory(){
		return service.getAllCategories();
	}
	
//	get category by id
	@GetMapping("/category/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return service.getCategoryById(id);
	}
	
//	delete category
	@DeleteMapping("/category/{id}")
	public String deleteCategory (@PathVariable int id) {
		return service.deleteCategory(id);
	}
}