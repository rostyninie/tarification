package com.producttarification.tarification.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.producttarification.tarification.business.factory.TarificationGeneratorFactory;
import com.producttarification.tarification.ibusiness.IProductTarificationControl;
import com.producttarification.tarification.models.Product;
import com.producttarification.tarification.models.Tarification;


public class ProductTarificationControl implements IProductTarificationControl {
	
	/**
	 * fix price of product
	 * @param product
	 * @return
	 */
	@Override
	public void fixPrice(Product product) {
		
		//use TarificationGeneratorFactory for get the right arificationGenerator of the product qualification type
		if(product != null && product.getTarification() != null) {
		Tarification tarification = new TarificationGeneratorFactory()
				.getGenerator(product.getTarification().getType()).fixPrice(product.getTarification());
		
		product.setTarification(tarification);
		}
			
	}
	
	/*
	 * Change tarification of product
	 * (non-Javadoc)
	 * @see com.producttarification.tarification.ibusiness.IProductPriceGenerator#changeProductTarification(com.producttarification.tarification.models.Product, com.producttarification.tarification.models.Tarification)
	 */
	@Override
	public void changeProductTarification(Product product, Tarification tarification) {
		if(product != null && tarification != null) {
			
			if(product.getTarification()!=null) {
				product.getTarification().setActive(false);
				tarification.setPriviousTarification(product.getTarification());
			}
			
		product.setTarification(tarification);
		fixPrice(product);
				
		}
	}
	
	/**
	 * get all tarifications that have made on product
	 */
	@Override
	public List<Tarification> getChronologieTarificationsOfProductForAudit(Product product){
		if(product != null && product.getTarification() != null && product.getTarification().getPriviousTarification() != null) {
			List<Tarification> tarifications = new ArrayList<>();
			getPreviousTarificationOfTarification(product.getTarification(), tarifications);
			Collections.reverse(tarifications);
			return tarifications;
		}else {
			return Collections.emptyList();
		}
	}
	
	private void getPreviousTarificationOfTarification(Tarification  tarification, List<Tarification> tarifications){

		tarifications.add(tarification);
		if(hasPreviousTarification(tarification)) {
			getPreviousTarificationOfTarification(tarification.getPriviousTarification(), tarifications);
		}
	}
	
	private boolean hasPreviousTarification(Tarification  tarification) {
		return tarification.getPriviousTarification()!=null;
	}
}
