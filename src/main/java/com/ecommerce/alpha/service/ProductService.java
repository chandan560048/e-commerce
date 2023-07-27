package com.ecommerce.alpha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.alpha.entity.ProductEntity;
import com.ecommerce.alpha.repository.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<ProductEntity> getAllProducts(){
		
		return repository.findAll();
		
	}
	
	public ProductEntity addProducts(@RequestBody ProductEntity product) {

		return repository.save(product);
	}

}
