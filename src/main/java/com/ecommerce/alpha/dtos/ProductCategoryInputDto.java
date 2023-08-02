package com.ecommerce.alpha.dtos;

import java.io.Serializable;
import java.util.Objects;

public class ProductCategoryInputDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCategoryInputDto other = (ProductCategoryInputDto) obj;
		return Objects.equals(categoryName, other.categoryName);
	}

	@Override
	public String toString() {
		return "ProductCategoryInputDto [categoryName=" + categoryName + "]";
	}

	public ProductCategoryInputDto(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
}
