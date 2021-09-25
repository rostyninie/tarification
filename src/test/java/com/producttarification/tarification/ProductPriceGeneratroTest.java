package com.producttarification.tarification;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.producttarification.tarification.business.ProductTarificationControl;
import com.producttarification.tarification.business.factory.TarificationGeneratorFactory;
import com.producttarification.tarification.business.tarificationgenerator.GiftTaricationGenerator;
import com.producttarification.tarification.business.tarificationgenerator.GroupTarificationGenerator;
import com.producttarification.tarification.business.tarificationgenerator.NormalTarificationGenerator;
import com.producttarification.tarification.enums.TarificationTypeEnum;
import com.producttarification.tarification.ibusiness.IProductTarificationControl;
import com.producttarification.tarification.ibusiness.TarificationGenerator;
import com.producttarification.tarification.models.GiftTarification;
import com.producttarification.tarification.models.GroupTarification;
import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;

/**
 * Unit test for price generator.
 */
public class ProductPriceGeneratroTest {
	
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
			Tarification tarification = new GiftTarification(1, new BigDecimal(10), TarificationTypeEnum.GIFT, null, 2, 1);
			return new Product(1,"001", tarification);
		}else if(type == 5){
			Tarification tarification = new GiftTarification(1, new BigDecimal(3), TarificationTypeEnum.GIFT, null, 3, 2);
			return new Product(1,"001", tarification);
		}else {
			Tarification tarification = new GiftTarification(1, new BigDecimal(3), TarificationTypeEnum.GROUP, null, 3, 2);
			return new Product(1,"001", tarification);
		}
	}
	
	private Tarification tarificationStub(int type) {
		if(type == 1) {
			return new GroupTarification(1, null, TarificationTypeEnum.GROUP, 3, new BigDecimal(20));
		}else if(type == 2) {
			return new GiftTarification(1, new BigDecimal(3), TarificationTypeEnum.GIFT, null, 3, 2);
		}else {
			return new Tarification(1, new BigDecimal(12), TarificationTypeEnum.NORMAL);
		}
	}
 
	@Test
	public void generateNormalProductPriceTest() {
		Product product = productStub(1);
		getProductTarificationControl().fixPrice(product);
		 BigDecimal price = product.getTarification().getPrice();
		assertEquals("ERROR",  new BigDecimal(20), price);
	}
	
	@Test
	public void generateProductPriceOf4ProductWithPriceOf3OfProduct() {
		Product product = productStub(2);
		getProductTarificationControl().fixPrice(product);
		 BigDecimal price = product.getTarification().getPrice().multiply(new BigDecimal(4));
		assertEquals(new BigDecimal("26.68"), price);
		
	}
	
	@Test
	public void generateProductPriceOf4OunceWithPriceOf1PoundTest() {
		Product product = productStub(3);
		getProductTarificationControl().fixPrice(product);
		 BigDecimal price = product.getTarification().getPrice().multiply(new BigDecimal(4));
		assertEquals(new BigDecimal("0.24"), price);
		
	}
	
	@Test
	public void generateProductPriceForGiftProductWheWeBuy2ProductAndGet1Test() {
		Product product = productStub(4);
		getProductTarificationControl().fixPrice(product);
		 BigDecimal price = ((GiftTarification)product.getTarification()).getGiftPrice();
		assertEquals(new BigDecimal("6.67"), price);
		
	}
	
	@Test
	public void generateProductPriceForGiftProductWheWeBuy3ProductAndGet2Test() {
		Product product = productStub(5);
		getProductTarificationControl().fixPrice(product);
		 BigDecimal price = ((GiftTarification)product.getTarification()).getGiftPrice();
		assertEquals(new BigDecimal("1.80"), price);
		
	}
	
	/*
	 * when the product tarification type is Normal then provide the NormalTarificationGenerator
	 */
	@Test
	public void getNormalTarificationGeneratorTest() {
		TarificationGenerator normalTarificationGenerator = new TarificationGeneratorFactory()
				                                             .getGenerator(TarificationTypeEnum.NORMAL);
		
		assertEquals(true,normalTarificationGenerator!=null && 
				normalTarificationGenerator instanceof NormalTarificationGenerator);
	}
	
	/*
	 * when the product tarification type is Group then provide the GroupTarificationGenerator
	 */
	@Test
	public void getGroupTarificationGeneratorTest() {
		TarificationGenerator groupTarificationGenerator = new TarificationGeneratorFactory()
				                                             .getGenerator(TarificationTypeEnum.GROUP);
		
		assertEquals(true,groupTarificationGenerator!=null && 
				groupTarificationGenerator instanceof GroupTarificationGenerator);
	}
	
	/*
	 * when the product tarification type is Gift then provide the GiftTarificationGenerator
	 */
	@Test
	public void getGiftTarificationGeneratorTest() {
		TarificationGenerator giftTarificationGenerator = new TarificationGeneratorFactory()
				                                             .getGenerator(TarificationTypeEnum.GIFT);
		
		assertEquals(true,giftTarificationGenerator!=null && 
				giftTarificationGenerator instanceof GiftTaricationGenerator);
	}
	
	/*
	 * When we pass bad type of tarification throw IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWhenWePassBadTypeOfTarification() {
		Product product = productStub(6);
		getProductTarificationControl().fixPrice(product);
	}
	
	/*
	 * when product change tarification keep hold tarification for audit
	 */
	@Test
	public void productChangeTarificationTest() {
		Product product = productStub(1);
		Tarification tarification =  tarificationStub(1);
		getProductTarificationControl().changeProductTarification(product, tarification);
		
		assertEquals(TarificationTypeEnum.GROUP, product.getTarification().getType());
		assertEquals(true, product.getTarification().isActive());
		assertEquals(TarificationTypeEnum.NORMAL, product.getTarification().getPriviousTarification().getType());
		assertEquals(false, product.getTarification().getPriviousTarification().isActive());
		
	}
	
	/*
	 * when product change tarification keep hold tarification for audit and fixe the new price of product with the new 
	 * tarification type
	 */
	@Test
	public void productChangeTarificationAndFixPriceOfNewTarificationTest() {
		Product product = productStub(1);
		Tarification tarification =  tarificationStub(1);
		IProductTarificationControl productTarificationControl = getProductTarificationControl();
		productTarificationControl.fixPrice(product);
		productTarificationControl.changeProductTarification(product, tarification);
		
		assertEquals(TarificationTypeEnum.GROUP, product.getTarification().getType());
		assertEquals(true, product.getTarification().isActive());
		assertEquals(new BigDecimal("6.67"), product.getTarification().getPrice());
		assertEquals(TarificationTypeEnum.NORMAL, product.getTarification().getPriviousTarification().getType());
		assertEquals(false, product.getTarification().getPriviousTarification().isActive());
		assertEquals(new BigDecimal(20), product.getTarification().getPriviousTarification().getPrice());
	}
	
	/*
	 * by what the product can change we can at a given time have chronologically all the tarifications 
	 * that has been made on a product
	 */
	@Test
	public void getChronologieOfTarificationsOfProduct() {
		Product product = productStub(1);
		IProductTarificationControl productTarificationControl = getProductTarificationControl();
		productTarificationControl.fixPrice(product);
		Tarification tarification1 =  tarificationStub(1);
		productTarificationControl.changeProductTarification(product, tarification1);
		Tarification tarification2 =  tarificationStub(2);
		productTarificationControl.changeProductTarification(product, tarification2);
		Tarification tarification3 =  tarificationStub(3);
		productTarificationControl.changeProductTarification(product, tarification3);
		List<Tarification> tarifications = productTarificationControl.getChronologieTarificationsOfProductForAudit(product);
		
		assertEquals(TarificationTypeEnum.NORMAL, tarifications.get(0).getType());
		assertEquals(new BigDecimal(20), tarifications.get(0).getPrice());
		assertEquals(false, tarifications.get(0).isActive());
		
		assertEquals(TarificationTypeEnum.GROUP, tarifications.get(1).getType());
		assertEquals(new BigDecimal("6.67"), tarifications.get(1).getPrice());
		assertEquals(false, tarifications.get(1).isActive());
		
		assertEquals(TarificationTypeEnum.GIFT, tarifications.get(2).getType());
		assertEquals(new BigDecimal("1.80"), ((GiftTarification)tarifications.get(2)).getGiftPrice());
		assertEquals(false, tarifications.get(2).isActive());
		
		assertEquals(TarificationTypeEnum.NORMAL, tarifications.get(3).getType());
		assertEquals(new BigDecimal(12), tarifications.get(3).getPrice());
		assertEquals(true, tarifications.get(3).isActive());
		
		
	}
	
	private ProductTarificationControl getProductTarificationControl() {
		return new ProductTarificationControl();
	}
	
	
}
