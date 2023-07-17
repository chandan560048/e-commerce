package com.amazone.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazone.demo.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
