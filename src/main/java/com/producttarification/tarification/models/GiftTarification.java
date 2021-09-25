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
	
	
	
	
	

}
