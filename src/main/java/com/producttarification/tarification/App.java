package com.producttarification.tarification;

import java.math.BigDecimal;
import java.util.List;

import com.producttarification.tarification.business.ProductPriceGenerator;
import com.producttarification.tarification.enums.TarificationTypeEnum;
import com.producttarification.tarification.ibusiness.IProductPriceGenerator;
import com.producttarification.tarification.models.GiftTarification;
import com.producttarification.tarification.models.GroupTarification;
import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;
import com.producttarification.tarification.utils.DisplayProduct;
import com.producttarification.tarification.utils.MyConsole;

/**
 * run tarification fixe price and tarifications chronologie for made audit on product tarification
 *
 */
public class App 
{
	private static MyConsole console = MyConsole.getInstance();
	
    public static void main( String[] args )
    {
    	Tarification tarification = new Tarification(1, new BigDecimal(20), TarificationTypeEnum.NORMAL);
    	Product product = new Product(1,"001", tarification);
    	
		IProductPriceGenerator productPriceTarification = new ProductPriceGenerator();
		productPriceTarification.fixPrice(product);
		DisplayProduct.displayProduct(product);
		console.displayF("");
		
		Tarification tarificationGroup =  new GroupTarification(1, null, TarificationTypeEnum.GROUP, 3, new BigDecimal(20));
		productPriceTarification.changeProductTarification(product, tarificationGroup);
		DisplayProduct.displayProduct(product);
		console.displayF("");
		
		Tarification tarificationGift =  new GiftTarification(1, new BigDecimal(3), TarificationTypeEnum.GIFT, null, 3, 2);
		productPriceTarification.changeProductTarification(product, tarificationGift);
		DisplayProduct.displayProduct(product);
		console.displayF("");
		
		Tarification tarificationNormal =  new Tarification(1, new BigDecimal(12), TarificationTypeEnum.NORMAL);
		productPriceTarification.changeProductTarification(product, tarificationNormal);
		DisplayProduct.displayProduct(product);
		console.displayF("");
		
		console.displayF("== Chronologie tarification of product : "+product.getProductCode());
		
		DisplayProduct.displayChronologieTarificationOfProduct(product);
	
    }
    
   
}
