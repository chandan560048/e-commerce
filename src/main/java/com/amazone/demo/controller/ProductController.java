package com.amazone.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazone.demo.entity.ProductEntity;
import com.amazone.demo.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository repository ;
	
	@GetMapping("/products")
	public List<ProductEntity> getAllProduct() {
		
		return repository.findAll();
	}
	
	@PostMapping("/addProduct")
	public ProductEntity addProducts(@RequestBody ProductEntity product) {
		
		
		return repository.save(product);
	}

}
