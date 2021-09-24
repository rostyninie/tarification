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
	
	public static final String GROUP = "group";
	public static final String NORMAL = "normal";
	
	private Product productStub(int type) {
		if(type == 1) {
		return new Product("001", new BigDecimal(20), NORMAL);
		}else if(type == 2) {
			return new Product("001", null, GROUP, 3, new BigDecimal(20));
		}else if(type == 3)  {
			// we know that 1 pound = 16 ounces
			// we difine the group price for 16 ounces directly
			return new Product("001", null, GROUP, 16, new BigDecimal(1));
		}else {
			return new Product("001", new BigDecimal(20), NORMAL);
		}
	}
 
	@Test
	public void generateNormalProductPriceTest() {
		Product product = productStub(1);
		BigDecimal price = new ProductPriceGenerator().fixPrice(product);
		assertEquals("ERROR",  new BigDecimal(20), price);
	}
	
	@Test
	public void generateProductPriceOf4ProductWithPriceOf3OfProduct() {
		Product product = productStub(2);
		BigDecimal price = new ProductPriceGenerator().fixPrice(product).multiply(new BigDecimal(4));
		assertEquals(new BigDecimal("26.68"), price);
		
	}
	
	@Test
	public void generateProductPriceOf4OunceWithPriceOf1PoundTest() {
		Product product = productStub(3);
		BigDecimal price = new ProductPriceGenerator().fixPrice(product).multiply(new BigDecimal(4));
		assertEquals(new BigDecimal("0.24"), price);
		
	}
	
	@Test
	public void generateProductPriceForGiftProductWheWeBuy2ProductAndGet1Test() {
		Product product = productStub(4);
		BigDecimal price = new ProductPriceGenerator().fixPrice(product).multiply(new BigDecimal(4));
		assertEquals(new BigDecimal("6.68"), price);
		
	}
}
