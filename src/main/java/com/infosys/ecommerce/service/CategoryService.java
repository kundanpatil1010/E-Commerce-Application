package com.infosys.ecommerce.service;

import java.util.List;

import com.infosys.ecommerce.model.Category;

public interface CategoryService {

//	save category
	public Category saveCategory(Category category);

//	update category
	public Category updateCategory(Category category, int id);

//	get all categories
	public List<Category> getAllCategories();

//	get category by id
	public Category getCategoryById(int id);

//	delete category
	public String deleteCategory(int id);
}