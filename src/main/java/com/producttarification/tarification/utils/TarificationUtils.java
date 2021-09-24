package com.producttarification.tarification.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TarificationUtils {
	
	/**
	 *  get decimal formated price
	 * @param price
	 * @return
	 */
	public static String formatBigDecimal(BigDecimal price) {
		DecimalFormat df = new DecimalFormat("####.00");
		return df.format(price);
	}

}
