package com.ecommerce.alpha.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.alpha.entity.ProductCategory;
import com.ecommerce.alpha.repository.ProductCategoryRepository;
import com.ecommerce.alpha.repository.ProductRepository;
import com.ecommerce.alpha.service.ProductCategoryService;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	
	private ProductCategoryRepository productCategoryRepository;
	
	private ProductRepository productRepository;
	
	ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ProductRepository productRepository) {
		this.productCategoryRepository = productCategoryRepository;
		this.productRepository = productRepository;
	}

	@Override
	public ProductCategory addCategory(ProductCategory productCategory) {
		return productCategoryRepository.saveAndFlush(productCategory);
	}

	@Override
	public List<ProductCategory> fetchAllCategory() {
		
		List<ProductCategory> list = productCategoryRepository.findAll();
		return list;
	}

}
