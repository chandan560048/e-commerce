package com.ecommerce.alpha.service;

import java.util.List;

import com.ecommerce.alpha.dtos.ProductCategoryInputDto;
import com.ecommerce.alpha.dtos.ProductCategoryOutputDto;
import com.ecommerce.alpha.dtos.ProductOutputDto;

public interface ProductCategoryService {

	ProductCategoryOutputDto addCategory(ProductCategoryInputDto productCategory);

	List<ProductCategoryOutputDto> fetchAllCategory();

	List<ProductOutputDto> fetchProductsWithCategoryName(String categoryName);

}
