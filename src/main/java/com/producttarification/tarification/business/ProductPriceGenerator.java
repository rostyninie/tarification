package com.producttarification.tarification.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.producttarification.tarification.models.Product;

public class ProductPriceGenerator {
	
	public static final String GROUP = "group";
	public static final String NORMAL = "normal";

	/**
	 * fix price of product
	 * @param product
	 * @return
	 */
	public BigDecimal fixPrice(Product product) {
		if(product.getType().equals(NORMAL)) {
			return product.getPrice();
		}else {
			//fix the price of product when we have price of group of product by divide the price of group
			//of product by number of product in group
			BigDecimal price = product.getPriceOfGroup()
					.divide(new BigDecimal(product.getNumberProductByGroup()), 2, RoundingMode.HALF_DOWN);
			product.setPrice(price);
			return price;
		}
		
	}
}
