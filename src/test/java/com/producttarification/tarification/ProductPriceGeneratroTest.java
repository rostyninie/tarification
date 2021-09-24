package com.producttarification.tarification;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.producttarification.tarification.business.ProductPriceGenerator;
import com.producttarification.tarification.models.Product;

/**
 * Unit test for price generator.
 */
public class ProductPriceGeneratroTest {
 
	@Test
	public void generateNormalProductPriceTest() {
		Product product = new Product("001", new BigDecimal(20));
		BigDecimal price = new ProductPriceGenerator().fixPrice(product);
		assertEquals("ERROR",  new BigDecimal(20), price);
	}
}
