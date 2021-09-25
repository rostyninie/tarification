package com.producttarification.tarification;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.producttarification.tarification.business.ProductPriceGenerator;
import com.producttarification.tarification.enums.TarificationTypeEnum;
import com.producttarification.tarification.models.GiftTarification;
import com.producttarification.tarification.models.GroupTarification;
import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;

/**
 * Unit test for price generator.
 */
public class ProductPriceGeneratroTest {
	
	public static final String GROUP = "group";
	public static final String NORMAL = "normal";
	public static final String GIFT = "gift";
	
	private Product productStub(int type) {
		if(type == 1) {
			Tarification tarification = new Tarification(1, new BigDecimal(20), TarificationTypeEnum.NORMAL);
		return new Product(1,"001", tarification);
		}else if(type == 2) {
			Tarification tarification = new GroupTarification(1, null, TarificationTypeEnum.GROUP, 3, new BigDecimal(20));
			return new Product(1,"001", tarification);
		}else if(type == 3)  {
			// we know that 1 pound = 16 ounces
			// we difine the group price for 16 ounces directly
			Tarification tarification = new GroupTarification(1, null, TarificationTypeEnum.GROUP, 16, new BigDecimal(1));
			return new Product(1,"001", tarification);
		}else if(type == 4){
			Tarification tarification = new GiftTarification(1, new BigDecimal(10), TarificationTypeEnum.GIFG, null, 2, 1);
			return new Product(1,"001", tarification);
		}else {
			Tarification tarification = new GiftTarification(1, new BigDecimal(3), TarificationTypeEnum.GIFG, null, 3, 2);
			return new Product(1,"001", tarification);
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
		BigDecimal price = new ProductPriceGenerator().fixPrice(product);
		assertEquals(new BigDecimal("6.67"), price);
		
	}
	
	@Test
	public void generateProductPriceForGiftProductWheWeBuy3ProductAndGet2Test() {
		Product product = productStub(5);
		BigDecimal price = new ProductPriceGenerator().fixPrice(product);
		assertEquals(new BigDecimal("1.80"), price);
		
	}
}
