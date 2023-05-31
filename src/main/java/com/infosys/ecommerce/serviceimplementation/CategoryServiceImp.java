package com.infosys.ecommerce.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.ecommerce.exception.CategoryNotFoundException;
import com.infosys.ecommerce.model.Category;
import com.infosys.ecommerce.repository.CategoryRepository;
import com.infosys.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{

	@Autowired
	private CategoryRepository repository;
	
//	save category
	@Override
	public Category saveCategory(Category category) {
		return repository.save(category);
	}

//	update category
	@Override
	public Category updateCategory(Category category, int id) {
		Category cat = getCategoryById(id);
		if(category.getName() != null) {
			cat.setName(category.getName());
		}
		if(category.getDescription() != null) {
			cat.setDescription(category.getDescription());
		}
		return repository.save(cat);
	}

//	get all categories
	@Override
	public List<Category> getAllCategories() {
		return repository.findAll();
	}

//	get category by id
	@Override
	public Category getCategoryById(int id) {
		return repository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
	}

//	delete category
	@Override
	public String deleteCategory(int id) {
		repository.deleteById(id);
		return "Category with ID " + id + " has been deleted";
	}
}