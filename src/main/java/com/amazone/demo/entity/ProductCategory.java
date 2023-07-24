package com.amazone.demo.entity;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class ProductCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
  //   @JsonIgnore
    private List<ProductEntity> products = new ArrayList<>();

    // Constructors

    public ProductCategory() {
        // Default constructor
    }
    

	public ProductCategory(@NotBlank String categoryName) {
		super();
		this.categoryName = categoryName;
	}


	public ProductCategory(Long id, @NotBlank String categoryName, List<ProductEntity> products) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + ", products=" + products + "]";
	}

   

    // Add other custom methods as needed

}
