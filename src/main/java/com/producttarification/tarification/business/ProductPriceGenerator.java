package com.producttarification.tarification.business;

import com.producttarification.tarification.business.factory.TarificationGeneratorFactory;
import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;

public class ProductPriceGenerator {
	
	/**
	 * fix price of product
	 * @param product
	 * @return
	 */
	public void fixPrice(Product product) {
		
		//use TarificationGeneratorFactory for get the right arificationGenerator of the product qualification type
		Tarification tarification = new TarificationGeneratorFactory()
				.getGenerator(product.getTarification().getType()).fixPrice(product.getTarification());
		
		product.setTarification(tarification);
		
		
	}
}
