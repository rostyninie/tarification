package com.producttarification.tarification.business;

import com.producttarification.tarification.business.factory.TarificationGeneratorFactory;
import com.producttarification.tarification.ibusiness.IProductPriceGenerator;
import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;

public class ProductPriceGenerator implements IProductPriceGenerator {
	
	/**
	 * fix price of product
	 * @param product
	 * @return
	 */
	@Override
	public void fixPrice(Product product) {
		
		//use TarificationGeneratorFactory for get the right arificationGenerator of the product qualification type
		Tarification tarification = new TarificationGeneratorFactory()
				.getGenerator(product.getTarification().getType()).fixPrice(product.getTarification());
		
		product.setTarification(tarification);
			
	}
	
	/*
	 * Change tarification of product
	 * (non-Javadoc)
	 * @see com.producttarification.tarification.ibusiness.IProductPriceGenerator#changeProductTarification(com.producttarification.tarification.models.Product, com.producttarification.tarification.models.Tarification)
	 */
	@Override
	public void changeProductTarification(Product product, Tarification tarification) {
		
	}
}
