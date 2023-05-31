package com.infosys.ecommerce.exception;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException (int id) {
		super("Could not found the product with ID " + id);
	}
}
