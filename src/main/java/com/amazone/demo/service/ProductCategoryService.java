//package com.amazone.demo.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.amazone.demo.entity.ProductCategory;
//import com.amazone.demo.repository.ProductCategoryRepository;
//
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//
//@Service
//public class ProductCategoryService {
//	
//	@Autowired
//	private ProductCategoryRepository repository;
//	
//	
//	public ProductCategory addProductByCategory(@RequestBody ProductCategory category) {
//		
//		return repository.save(category);
//	}
//	
//	public List<ProductCategory> geProductByCategory(){
//		
//		return repository.findAll();
//	}
//
//}
