package com.producttarification.tarification.models;

import java.math.BigDecimal;

import com.producttarification.tarification.enums.TarificationTypeEnum;

public class Tarification {
	private long tarificationId;
	private BigDecimal price;
	private TarificationTypeEnum type;
	
	public Tarification(long tarificationId, BigDecimal price, TarificationTypeEnum type) {
		
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

	public TarificationTypeEnum getType() {
		return type;
	}

	public void setType(TarificationTypeEnum type) {
		this.type = type;
	}	

}
