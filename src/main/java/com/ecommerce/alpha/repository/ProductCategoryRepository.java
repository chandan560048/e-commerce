package com.ecommerce.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.alpha.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

	ProductCategory findByCategoryName(String name);

}
