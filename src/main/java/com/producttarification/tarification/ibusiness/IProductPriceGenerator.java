package com.producttarification.tarification.ibusiness;

import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;

public interface IProductPriceGenerator {
	
	void fixPrice(Product product) ;
	
	void changeProductTarification(Product product, Tarification tarification);

}
