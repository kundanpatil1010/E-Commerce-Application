package com.infosys.ecommerce.serviceimplementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.infosys.ecommerce.exception.ProductNotFoundException;
import com.infosys.ecommerce.model.Category;
import com.infosys.ecommerce.model.Product;
import com.infosys.ecommerce.repository.CategoryRepository;
import com.infosys.ecommerce.repository.ProductRepository;
import com.infosys.ecommerce.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
//	save product
	@Override
	public Product saveProduct(Product product, int categoryId) {
		Category category = categoryRepository.findById(categoryId).get();
		product.setCategory(category);
		return repository.save(product);
	}

//	update product
	@Override
	public Product updateProduct(Product product, int productId, int categoryId) {
		Product prod = getProductById(productId);
		if(product.getName() != null) {
			prod.setName(product.getName());
		}
		if(product.getPrice() != null) {
			prod.setPrice(product.getPrice());
		}
		if(product.getDescription() != null) {
			prod.setDescription(product.getDescription());
		}
		Category category = categoryRepository.findById(categoryId).get();
		prod.setCategory(category);
		return repository.save(prod);
	}

//	get all products
	@Override
	public List<Product> getAllProduct() {
		return repository.findAll();
	}

//	get product by id
	@Override
	public Product getProductById(int id) {
		return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

//	delete product
	@Override
	public String deleteProduct(int id) {
		if(getProductById(id) == null) {
			throw new ProductNotFoundException(id);
		}
		repository.deleteById(id);
		return "Product with ID " + id + " has been deleted";
	}
	
//============{ Custom Finder Methods }============

//	find product by name
	@Override
	public List<Product> findByName(String name) {
		return repository.findByName(name);
	}

//	find product by price
	@Override
	public List<Product> findByPrice(Integer price) {
		return repository.findByPrice(price);
	}
	
//	find product by category name
	@Override
	public List<Product> findByCategoryName(String categoryName) {
		return repository.findByCategoryName(categoryName);
	}

//	Pagination method
	@Override
	public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		return null;
	}
}