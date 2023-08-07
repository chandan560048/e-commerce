package com.ecommerce.alpha.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ecommerce.alpha.dtos.ProductCategoryInputDto;
import com.ecommerce.alpha.dtos.ProductCategoryOutputDto;
import com.ecommerce.alpha.dtos.ProductOutputDto;
import com.ecommerce.alpha.entity.ProductCategory;
import com.ecommerce.alpha.entity.ProductEntity;
import com.ecommerce.alpha.exception.NotFoundException;
import com.ecommerce.alpha.repository.ProductCategoryRepository;
import com.ecommerce.alpha.repository.ProductRepository;
import com.ecommerce.alpha.service.ProductCategoryService;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	
	private ProductCategoryRepository productCategoryRepository;
	
	private ProductRepository productRepository;
	
	private ModelMapper modelMapper;
	
	ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ProductRepository productRepository, ModelMapper modelMapper) {
		this.productCategoryRepository = productCategoryRepository;
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductCategoryOutputDto addCategory(ProductCategoryInputDto productCategory) {
		ProductCategory product = productCategoryRepository.saveAndFlush(modelMapper.map(productCategory, ProductCategory.class));
		return modelMapper.map(product, ProductCategoryOutputDto.class);
	}

	@Override
	public List<ProductCategoryOutputDto> fetchAllCategory() {		
		List<ProductCategory> list = productCategoryRepository.findAll();
		 return Arrays.asList(modelMapper.map(list, ProductCategoryOutputDto[].class));
	}

	@Override
	public List<ProductOutputDto> fetchProductsWithCategoryName(String categoryName) {
		ProductCategory category = productCategoryRepository.findByCategoryName(categoryName);
		if(category == null) {
			throw new NotFoundException("ProductCategory NOT Found");
		}
		 List<ProductEntity> products = productRepository.findByCategoryId(category.getId());
		 return Arrays.asList(modelMapper.map(products, ProductOutputDto[].class));
	}

}
