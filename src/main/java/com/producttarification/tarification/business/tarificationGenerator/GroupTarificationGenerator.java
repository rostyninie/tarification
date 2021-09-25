package com.producttarification.tarification.business.tarificationGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.producttarification.tarification.ibusiness.TarificationGenerator;
import com.producttarification.tarification.models.GroupTarification;
import com.producttarification.tarification.models.Tarification;

public class GroupTarificationGenerator implements TarificationGenerator {
	
	/*
	 * implementation for fix price of product when the price is define for a group of product
	 * (non-Javadoc)
	 * @see com.producttarification.tarification.ibusiness.TarificationGenerator#fixPrice(com.producttarification.tarification.models.Tarification)
	 */
	@Override
	public GroupTarification fixPrice(Tarification tarification) {
		GroupTarification groupTarification = null;
		
		/*fix the price of product when we have price of group of product by divide the price of group
		of product by number of product in group*/
		
		if(tarification instanceof GroupTarification && 
				((GroupTarification)tarification).getNumberProductByGroup()>0) {
			
		    groupTarification = (GroupTarification)tarification;
			
		    BigDecimal price = groupTarification.getPriceOfGroup()
				.divide(new BigDecimal(groupTarification.getNumberProductByGroup()), 2, RoundingMode.HALF_DOWN);
		
			groupTarification.setPrice(price);
		}
		
		return groupTarification;
	}

}
