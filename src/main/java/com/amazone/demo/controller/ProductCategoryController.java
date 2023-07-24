package com.amazone.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazone.demo.entity.ProductCategory;
import com.amazone.demo.entity.ProductEntity;
import com.amazone.demo.repository.ProductCategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class ProductCategoryController {

	private final ProductCategoryRepository categoryRepository;

	@Autowired
	public ProductCategoryController(ProductCategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	// Endpoint to save a new category
	@PostMapping("/add-category-with-product")
	public ResponseEntity<ProductCategory> addCategoryWithProduct(@RequestBody ProductCategory productCategory) {
		if (productCategory.getCategoryName() == null || productCategory.getProducts().isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		for (ProductEntity product : productCategory.getProducts()) {
			product.setCategory(productCategory);
		}

		ProductCategory savedCategory = categoryRepository.save(productCategory);
		return ResponseEntity.ok(savedCategory);
	}

	@GetMapping
    public ResponseEntity<List<String>> getAllCategoryNames() {
        List<String> categoryNames = categoryRepository.findAllCategoryNames();
        return ResponseEntity.ok(categoryNames);
    }

}
