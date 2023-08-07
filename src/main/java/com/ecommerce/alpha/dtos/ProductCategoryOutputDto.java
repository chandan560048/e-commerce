package com.ecommerce.alpha.dtos;

import java.io.Serializable;
import java.util.Objects;

public class ProductCategoryOutputDto implements Serializable{

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
		ProductCategoryOutputDto other = (ProductCategoryOutputDto) obj;
		return Objects.equals(categoryName, other.categoryName);
	}

	@Override
	public String toString() {
		return "ProductCategoryOutputDto [categoryName=" + categoryName + "]";
	}

}
