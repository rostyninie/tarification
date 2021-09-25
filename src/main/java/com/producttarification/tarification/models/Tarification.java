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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + (int) (tarificationId ^ (tarificationId >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarification other = (Tarification) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (tarificationId != other.tarificationId)
			return false;
		if (type != other.type)
			return false;
		return true;
	}	
	
	

}
