package com.producttarification.tarification.models;

import java.math.BigDecimal;

import com.producttarification.tarification.enums.TarificationTypeEnum;

public class GroupTarification extends Tarification {

	private int numberProductByGroup;
	private BigDecimal priceOfGroup;
	
	public GroupTarification(long tarificationId, BigDecimal price, TarificationTypeEnum type, int numberProductByGroup,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numberProductByGroup;
		result = prime * result + ((priceOfGroup == null) ? 0 : priceOfGroup.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupTarification other = (GroupTarification) obj;
		if (numberProductByGroup != other.numberProductByGroup)
			return false;
		if (priceOfGroup == null) {
			if (other.priceOfGroup != null)
				return false;
		} else if (!priceOfGroup.equals(other.priceOfGroup))
			return false;
		return true;
	}
	
	
	
}
