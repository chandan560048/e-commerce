package com.ecommerce.alpha.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Data
@Setter
@Getter
@Table(name = "product" )
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(initialValue = 1, name = "prod_seq", sequenceName = "product_sequence")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;

	@Column
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private ProductCategory productCategoryId;

	public ProductEntity() {
		super();
	}

	public ProductEntity(Long id, String name, String description, double price, ProductCategory productCategoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.productCategoryId = productCategoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductCategory getProductCategoryId() {
		return productCategoryId;
	}

   public void setProductCategoryId(ProductCategory productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	
}
