package com.amazone.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazone.demo.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

	ProductCategory findByCategoryName(String categoryName);
	
	 @Query("SELECT categoryName FROM ProductCategory")
	    List<String> findAllCategoryNames();

}
