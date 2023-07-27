package com.ecommerce.alpha.service;

import java.util.List;

import com.ecommerce.alpha.entity.ProductCategory;

public interface ProductCategoryService {

	ProductCategory addCategory(ProductCategory productCategory);

	List<ProductCategory> fetchAllCategory();

}
