package com.producttarification.tarification.business.tarificationGenerator;

import com.producttarification.tarification.ibusiness.TarificationGenerator;
import com.producttarification.tarification.models.Tarification;

public class NormalTarificationGenerator implements TarificationGenerator {

	/*
	 * implementation for get normal tarification
	 * (non-Javadoc)
	 * @see com.producttarification.tarification.ibusiness.TarificationGenerator#fixPrice(com.producttarification.tarification.models.Tarification)
	 */
	@Override
	public Tarification fixPrice(Tarification tarification) {
		if(tarification instanceof Tarification == false) {
			String message = String.format("can not generate fix price of Normal tarification with Normal %s", tarification.getClass().getSimpleName());
			throw new IllegalArgumentException(message);
		}
		return tarification;
	}

}
