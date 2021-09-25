package com.producttarification.tarification.models;

import java.math.BigDecimal;

public class Product {
	
	private long productId;
	private String productCode;
	private Tarification tarification;
	
	public Product(long productId, String productCode, Tarification tarification) {
		this.productId = productId;
		this.productCode = productCode;
		this.tarification = tarification;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Tarification getTarification() {
		return tarification;
	}

	public void setTarification(Tarification tarification) {
		this.tarification = tarification;
	}
	
}
