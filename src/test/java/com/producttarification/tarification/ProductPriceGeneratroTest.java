package com.producttarification.tarification;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.producttarification.tarification.business.ProductPriceGenerator;
import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.utils.TarificationUtils;

/**
 * Unit test for price generator.
 */
public class ProductPriceGeneratroTest {
	
	private Product productStub() {
		return new Product("001", new BigDecimal(20));
	}
 
	@Test
	public void generateNormalProductPriceTest() {
		Product product = productStub();
		BigDecimal price = new ProductPriceGenerator().fixPrice(product);
		assertEquals("ERROR",  new BigDecimal(20), price);
	}
	
	@Test
	public void generateProductPriceOf4ProductWithPriceOf3OfProduct() {
		Product product = productStub();
		BigDecimal price = new ProductPriceGenerator().fixPrice(product);
		assertEquals("26.67", TarificationUtils.formatBigDecimal(price));
		
	}
}
