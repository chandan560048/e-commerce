package com.ecommerce.alpha.service;

import java.util.List;

import com.ecommerce.alpha.dtos.ProductInputDto;
import com.ecommerce.alpha.dtos.ProductOutputDto;


public interface ProductService {

	
	List<ProductOutputDto> getAllProducts();
	
	ProductOutputDto addProducts(ProductInputDto product, String categoryName);

}
