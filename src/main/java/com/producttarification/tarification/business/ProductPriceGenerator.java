package com.producttarification.tarification.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.producttarification.tarification.enums.TarificationTypeEnum;
import com.producttarification.tarification.models.GiftTarification;
import com.producttarification.tarification.models.GroupTarification;
import com.producttarification.tarification.models.Product;

public class ProductPriceGenerator {
	
	/**
	 * fix price of product
	 * @param product
	 * @return
	 */
	public BigDecimal fixPrice(Product product) {
		if(product.getTarification().getType().equals(TarificationTypeEnum.NORMAL)) {
			return product.getTarification().getPrice();
		}else if(product.getTarification().getType().equals(TarificationTypeEnum.GROUP)) {
			/*fix the price of product when we have price of group of product by divide the price of group
			of product by number of product in group*/
			
			BigDecimal price = null;
			
			if(product.getTarification() instanceof GroupTarification && 
					((GroupTarification)product.getTarification()).getNumberProductByGroup()>0) {
				
				GroupTarification tarification = (GroupTarification)product.getTarification();
				price = tarification.getPriceOfGroup()
					.divide(new BigDecimal(tarification.getNumberProductByGroup()), 2, RoundingMode.HALF_DOWN);
			
				tarification.setPrice(price);
				product.setTarification(tarification);
			}
			
			return price;
		}else {
			/* fix the price of gift product by divide the total price for number of product to get gift by
			 the number of product to get gift plus the number of gift product*/
			
			BigDecimal giftPrice = null;
			
			if(product.getTarification() instanceof GiftTarification) {
				GiftTarification tarification = (GiftTarification)product.getTarification();
				if((tarification.getNumberProductForGetGift() + tarification.getNumberOfGift())>0) {
					
					giftPrice = tarification.getPrice().multiply(new BigDecimal(tarification.getNumberProductForGetGift()))
							.divide(new BigDecimal(tarification.getNumberProductForGetGift()+tarification.getNumberOfGift()),
									2, RoundingMode.HALF_DOWN);
					
					tarification.setGiftPrice(giftPrice);
					product.setTarification(tarification);
					
					
				}
			}
				
			return giftPrice;
		}
		
	}
}
