package com.producttarification.tarification.models;

import java.math.BigDecimal;

import com.producttarification.tarification.enums.TarificationTypeEnum;

public class GiftTarification extends Tarification {
	
	private BigDecimal giftPrice;
	private int numberProductForGetGift;
	private int numberOfGift;
	
	public GiftTarification(long tarificationId, BigDecimal price, TarificationTypeEnum type, BigDecimal giftPrice,
			int numberProductForGetGift, int numberOfGift) {
		
		super(tarificationId, price, type);
		this.giftPrice = giftPrice;
		this.numberProductForGetGift = numberProductForGetGift;
		this.numberOfGift = numberOfGift;
	}

	public BigDecimal getGiftPrice() {
		return giftPrice;
	}

	public void setGiftPrice(BigDecimal giftPrice) {
		this.giftPrice = giftPrice;
	}

	public int getNumberProductForGetGift() {
		return numberProductForGetGift;
	}

	public void setNumberProductForGetGift(int numberProductForGetGift) {
		this.numberProductForGetGift = numberProductForGetGift;
	}

	public int getNumberOfGift() {
		return numberOfGift;
	}

	public void setNumberOfGift(int numberOfGift) {
		this.numberOfGift = numberOfGift;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((giftPrice == null) ? 0 : giftPrice.hashCode());
		result = prime * result + numberOfGift;
		result = prime * result + numberProductForGetGift;
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
		GiftTarification other = (GiftTarification) obj;
		if (giftPrice == null) {
			if (other.giftPrice != null)
				return false;
		} else if (!giftPrice.equals(other.giftPrice))
			return false;
		if (numberOfGift != other.numberOfGift)
			return false;
		if (numberProductForGetGift != other.numberProductForGetGift)
			return false;
		return true;
	}
	

}
