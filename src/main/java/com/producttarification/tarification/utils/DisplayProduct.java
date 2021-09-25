package com.producttarification.tarification.utils;

import java.util.List;

import com.producttarification.tarification.business.ProductPriceGenerator;
import com.producttarification.tarification.enums.TarificationTypeEnum;
import com.producttarification.tarification.ibusiness.IProductPriceGenerator;
import com.producttarification.tarification.models.GiftTarification;
import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;

public class DisplayProduct {
	
	private static MyConsole console = MyConsole.getInstance();
	
	 public static void displayProduct(Product product) {
		 
		 if(product != null && product.getTarification() != null) {
	    	if(product.getTarification().getType().equals(TarificationTypeEnum.GIFT)) {
	    		console.displayF(product.toString());
	    		console.displayF("Fixe price for gift : "+((GiftTarification)product.getTarification()).getGiftPrice());
	    	}else {
	    		console.displayF(product.toString());
	    	}
		 }
	   }
	    
	    public static void displayChronologieTarificationOfProduct(Product product) {
	    	
	    	IProductPriceGenerator productPricegGenerator = new ProductPriceGenerator();
	    	List<Tarification> tarifications = productPricegGenerator.getChronologieTarificationsOfProductForAudit(product);
	    	
	    	if(!tarifications.isEmpty()) {
	    		tarifications.forEach(tarification->{
	    			if(tarification.getType().equals(TarificationTypeEnum.GIFT)) {
			    		console.displayF(tarification.toString());
			    		console.displayF("Fixe price for gift : "+((GiftTarification)tarification).getGiftPrice());
			    		console.displayF("");
			    	}else {
			    		console.displayF(tarification.toString());
			    		console.displayF("");
			    	}
	    		});
		    	
	    	}
	    }

}
