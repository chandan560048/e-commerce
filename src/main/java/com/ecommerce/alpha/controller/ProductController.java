package com.ecommerce.alpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.alpha.dtos.ProductInputDto;
import com.ecommerce.alpha.dtos.ProductOutputDto;
import com.ecommerce.alpha.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public ResponseEntity<List<ProductOutputDto>> getAllProduct() {
		return new ResponseEntity<List<ProductOutputDto>>(service.getAllProducts(), HttpStatus.OK);
	}

	@PostMapping("/addProduct")
	public ResponseEntity<ProductOutputDto> addProducts(@RequestBody ProductInputDto product, @RequestParam String categoryName) {
		return new ResponseEntity<ProductOutputDto>(service.addProducts(product, categoryName), HttpStatus.OK);
	}
	
	@GetMapping("findProduct/{productName}")
	public ResponseEntity<ProductOutputDto> findProduct(@PathVariable String productName) {
		return new ResponseEntity<ProductOutputDto>(service.findProduct(productName), HttpStatus.OK);
	}

}
