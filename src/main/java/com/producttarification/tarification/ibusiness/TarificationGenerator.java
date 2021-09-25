package com.producttarification.tarification.ibusiness;

import com.producttarification.tarification.models.Tarification;

public interface TarificationGenerator {
	
	Tarification fixPrice(Tarification tarification);

}
