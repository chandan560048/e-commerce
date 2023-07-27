package com.ecommerce.alpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.alpha.entity.ProductEntity;
import com.ecommerce.alpha.repository.ProductRepository;
import com.ecommerce.alpha.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public List<ProductEntity> getAllProduct() {

		return service.getAllProducts();
	}

	@PostMapping("/addProduct")
	public ProductEntity addProducts(@RequestBody ProductEntity product) {

		return service.addProducts(product);
	}

	@GetMapping("/testApi")
	public String testApi() {

		return "testing api successful";
	}

}
