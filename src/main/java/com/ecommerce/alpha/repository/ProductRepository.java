package com.ecommerce.alpha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.alpha.entity.ProductEntity;
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByCategoryId(Long id);

}
