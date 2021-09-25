package com.producttarification.tarification.business.tarificationgenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.producttarification.tarification.ibusiness.TarificationGenerator;
import com.producttarification.tarification.models.GiftTarification;
import com.producttarification.tarification.models.Tarification;

public class GiftTaricationGenerator implements TarificationGenerator {

	@Override
	public GiftTarification fixPrice(Tarification tarification) {
		GiftTarification giftTarification = null;
		/* fix the price of gift product by divide the total price for number of product to get gift by
		 the number of product to get gift plus the number of gift product*/
		
		
		if(tarification instanceof GiftTarification) { // check if is right instance of tarification
			giftTarification = (GiftTarification)tarification;
			if((giftTarification.getNumberProductForGetGift() + giftTarification.getNumberOfGift())>0) { /* check 
				 NumberProductForGetGift and NumberOfGift to avoid division by 0 */
				
				BigDecimal giftPrice = giftTarification.getPrice().multiply(new BigDecimal(giftTarification.getNumberProductForGetGift()))
						.divide(new BigDecimal(giftTarification.getNumberProductForGetGift()+giftTarification.getNumberOfGift()),
								2, RoundingMode.HALF_DOWN);
				
				giftTarification.setGiftPrice(giftPrice);
				
			}else {
				String message = String.format("can not generate fix price of Gift tarification with NumberProductForGetGift = %d "
						+ " and NumberOfGift = %d", giftTarification.getNumberProductForGetGift(), giftTarification.getNumberOfGift());
				throw new IllegalArgumentException(message);
			}
		}else {
			String message = String.format("can not generate fix price of Gift tarification with %s", tarification.getClass().getSimpleName());
			throw new IllegalArgumentException(message);
		}
		return giftTarification;
	}

}
