package com.ecommerce.alpha.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="product_category")
public class ProductCategory implements Serializable{

	private static final long serialVersionUID = 1749451758546303103L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productCategory_seq")
    @SequenceGenerator(initialValue = 1, name = "prodCate_seq", sequenceName = "productCategory_sequence")
	private Long id;
	
	@Column
	private String categoryName;
	
	@Column
	@OneToMany(targetEntity=ProductEntity.class, cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "product_category_id", referencedColumnName = "id")
	private List<ProductEntity> product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
