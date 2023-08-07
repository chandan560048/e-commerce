package com.ecommerce.alpha.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.ecommerce.alpha.exception.NotFoundException;
import com.ecommerce.alpha.dtos.ProductInputDto;
import com.ecommerce.alpha.dtos.ProductOutputDto;
import com.ecommerce.alpha.entity.ProductCategory;
import com.ecommerce.alpha.entity.ProductEntity;
import com.ecommerce.alpha.repository.ProductCategoryRepository;
import com.ecommerce.alpha.repository.ProductRepository;
import com.ecommerce.alpha.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	private ProductCategoryRepository productCategoryRepository;
	
	private ModelMapper modelMapper;
	
	ProductServiceImpl(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.productCategoryRepository = productCategoryRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ProductOutputDto> getAllProducts() {
		return Arrays.asList(modelMapper.map(productRepository.findAll(), ProductOutputDto[].class));
	}

	@Override
	public ProductOutputDto addProducts(ProductInputDto product, String categoryName) {
		ProductCategory category = productCategoryRepository.findByCategoryName(categoryName);
		if(category == null) {
			throw new NotFoundException("ProductCategory NOT Found");
		}
		ProductEntity productObject = modelMapper.map(product, ProductEntity.class);
		productObject.setCategoryId(category.getId());
		return modelMapper.map(productRepository.saveAndFlush(productObject), ProductOutputDto.class);
	}

	@Override
	public ProductOutputDto findProduct(String productName) {
		ProductEntity productObj = productRepository.findByName(productName);
		if(productObj == null) {
			throw new NotFoundException("Product Not Found: " +productName);
		}
		return modelMapper.map(productObj, ProductOutputDto.class);
	}

}
