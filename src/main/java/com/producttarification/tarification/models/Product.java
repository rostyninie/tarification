package com.producttarification.tarification.models;

import java.math.BigDecimal;

public class Product {
	
	private String id;
	private BigDecimal price;
	
	public Product(String id, BigDecimal price) {
		this.id = id;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
