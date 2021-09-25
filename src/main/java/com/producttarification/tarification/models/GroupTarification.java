package com.producttarification.tarification.models;

import java.math.BigDecimal;

public class GroupTarification extends Tarification {

	private int numberProductByGroup;
	private BigDecimal priceOfGroup;
	
	public GroupTarification(long tarificationId, BigDecimal price, String type, int numberProductByGroup,
			BigDecimal priceOfGroup) {
		
		super(tarificationId, price, type);
		this.numberProductByGroup = numberProductByGroup;
		this.priceOfGroup = priceOfGroup;
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
