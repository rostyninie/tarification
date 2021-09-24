package com.producttarification.tarification.models;

import java.math.BigDecimal;

public class Product {
	
	private String id;
	private BigDecimal price;
	private String type;
	private int numberProductByGroup;
	private BigDecimal priceOfGroup;
	
	public Product(String id, BigDecimal price, String type) {
		this.id = id;
		this.price = price;
		this.type = type;
	}

	public Product(String id, BigDecimal price, String type, int numberProductByGroup, BigDecimal priceOfGroup) {
		this.id = id;
		this.price = price;
		this.type = type;
		this.numberProductByGroup = numberProductByGroup;
		this.priceOfGroup = priceOfGroup;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberProductByGroup() {
		return numberProductByGroup;
	}

	public void setNumberProductByGroup(int numberProductByGroup) {
		this.numberProductByGroup = numberProductByGroup;
	}

	public BigDecimal getPriceOfGroup() {
		return priceOfGroup;
	}

	public void setPriceOfGroup(BigDecimal priceOfGroup) {
		this.priceOfGroup = priceOfGroup;
	}
	
	
	
}
