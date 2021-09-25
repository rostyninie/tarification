package com.producttarification.tarification.models;

import java.math.BigDecimal;

public class Tarification {
	private long tarificationId;
	private BigDecimal price;
	private String type;
	
	public Tarification(long tarificationId, BigDecimal price, String type) {
		
		this.tarificationId = tarificationId;
		this.price = price;
		this.type = type;
	}

	public long getTarificationId() {
		return tarificationId;
	}

	public void setTarificationId(long tarificationId) {
		this.tarificationId = tarificationId;
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

}
