package com.producttarification.tarification.ibusiness;

import java.util.List;

import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;

public interface IProductTarificationControl {
	
	void fixPrice(Product product) ;
	
	void changeProductTarification(Product product, Tarification tarification);
	
	List<Tarification> getChronologieTarificationsOfProductForAudit(Product product);

}
