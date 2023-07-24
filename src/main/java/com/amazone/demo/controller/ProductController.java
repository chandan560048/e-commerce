package com.amazone.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazone.demo.entity.ProductCategory;
import com.amazone.demo.entity.ProductEntity;
import com.amazone.demo.repository.ProductCategoryRepository;
import com.amazone.demo.repository.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductCategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	@Autowired
	public ProductController(ProductCategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	// Endpoint to save a new product
	@PostMapping
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductEntity> saveProduct(@Valid @RequestBody ProductEntity product) {
		ProductEntity savedProduct = productRepository.save(product);
		return ResponseEntity.ok(savedProduct);
	}

	// Endpoint to get all products
	@GetMapping
	public ResponseEntity<Iterable<ProductEntity>> getAllProducts() {
		Iterable<ProductEntity> products = productRepository.findAll();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/by-category/{categoryName}")
	public ResponseEntity<List<ProductEntity>> findProductsByCategory(@PathVariable String categoryName) {
		ProductCategory category = categoryRepository.findByCategoryName(categoryName);

		if (category == null) {
			return ResponseEntity.notFound().build();
		}

		List<ProductEntity> products = category.getProducts();
		return ResponseEntity.ok(products);
	}

}
