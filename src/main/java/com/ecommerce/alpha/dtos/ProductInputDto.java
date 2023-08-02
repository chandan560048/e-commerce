package com.ecommerce.alpha.dtos;

import java.io.Serializable;
import java.util.Objects;

public class ProductInputDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private double price;

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

	@Override
	public int hashCode() {
		return Objects.hash(description, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInputDto other = (ProductInputDto) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	public ProductInputDto(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductInputDto [name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	
}
