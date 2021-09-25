package com.producttarification.tarification.business.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.producttarification.tarification.business.tarificationgenerator.GiftTaricationGenerator;
import com.producttarification.tarification.business.tarificationgenerator.GroupTarificationGenerator;
import com.producttarification.tarification.business.tarificationgenerator.NormalTarificationGenerator;
import com.producttarification.tarification.enums.TarificationTypeEnum;
import com.producttarification.tarification.ibusiness.TarificationGenerator;

public class TarificationGeneratorFactory {
	
	// map for prive corresponding tarification generator of tarification type
	private Map<TarificationTypeEnum, Supplier<TarificationGenerator>> tarificationGeneratorProvider = new HashMap<>();

	{
		tarificationGeneratorProvider.put(TarificationTypeEnum.NORMAL, NormalTarificationGenerator::new);
		tarificationGeneratorProvider.put(TarificationTypeEnum.GROUP, GroupTarificationGenerator::new);
		tarificationGeneratorProvider.put(TarificationTypeEnum.GIFT, GiftTaricationGenerator::new);
	}
	
	/*
	 * Provide tarification generator by tarification type
	 */
	public TarificationGenerator getGenerator(TarificationTypeEnum type) {
		return tarificationGeneratorProvider.get(type).get();
	}
}

