package com.ecommerce.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.alpha.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
