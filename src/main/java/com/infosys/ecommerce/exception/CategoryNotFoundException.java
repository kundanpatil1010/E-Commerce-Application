package com.infosys.ecommerce.exception;

public class CategoryNotFoundException extends RuntimeException {
	
	public CategoryNotFoundException (int id) {
		super("Could not found the category with ID " + id);
	}
}