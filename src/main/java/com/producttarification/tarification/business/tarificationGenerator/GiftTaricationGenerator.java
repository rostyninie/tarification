package com.producttarification.tarification.business.tarificationGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.producttarification.tarification.ibusiness.TarificationGenerator;
import com.producttarification.tarification.models.GiftTarification;
import com.producttarification.tarification.models.GroupTarification;
import com.producttarification.tarification.models.Tarification;

public class GiftTaricationGenerator implements TarificationGenerator {

	@Override
	public GiftTarification fixPrice(Tarification tarification) {
		GiftTarification giftTarification = null;
		/* fix the price of gift product by divide the total price for number of product to get gift by
		 the number of product to get gift plus the number of gift product*/
		
		
		if(tarification instanceof GiftTarification) {
			giftTarification = (GiftTarification)tarification;
			if((giftTarification.getNumberProductForGetGift() + giftTarification.getNumberOfGift())>0) {
				
				BigDecimal giftPrice = giftTarification.getPrice().multiply(new BigDecimal(giftTarification.getNumberProductForGetGift()))
						.divide(new BigDecimal(giftTarification.getNumberProductForGetGift()+giftTarification.getNumberOfGift()),
								2, RoundingMode.HALF_DOWN);
				
				giftTarification.setGiftPrice(giftPrice);
				
			}
		}
		return giftTarification;
	}

}
