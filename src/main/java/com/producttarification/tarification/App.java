package com.producttarification.tarification;

import java.math.BigDecimal;

import com.producttarification.tarification.business.ProductTarificationControl;
import com.producttarification.tarification.enums.TarificationTypeEnum;
import com.producttarification.tarification.ibusiness.IProductTarificationControl;
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
    	
    	// fixe price for normal tarification
		IProductTarificationControl productTarificationControl = new ProductTarificationControl();
		productTarificationControl.fixPrice(product);
		DisplayProduct.displayProduct(product);
		console.displayF("");
		
		// change tarification of product for Group and fixe et new  price 
		Tarification tarificationGroup =  new GroupTarification(1, null, TarificationTypeEnum.GROUP, 3, new BigDecimal(20));
		productTarificationControl.changeProductTarification(product, tarificationGroup);
		DisplayProduct.displayProduct(product);
		console.displayF("");
		
		// change tarification of product for Group and fixe the price for gift product 
		Tarification tarificationGift =  new GiftTarification(1, new BigDecimal(3), TarificationTypeEnum.GIFT, null, 3, 2);
		productTarificationControl.changeProductTarification(product, tarificationGift);
		DisplayProduct.displayProduct(product);
		console.displayF("");
		
		// change tarification of product to normal 
		Tarification tarificationNormal =  new Tarification(1, new BigDecimal(12), TarificationTypeEnum.NORMAL);
		productTarificationControl.changeProductTarification(product, tarificationNormal);
		DisplayProduct.displayProduct(product);
		console.displayF("");
		
		console.displayF("== Chronologie tarification of product : "+product.getProductCode());
		
		// display chronologie tarifications of product
		DisplayProduct.displayChronologieTarificationOfProduct(product);
	
    }
    
   
}
