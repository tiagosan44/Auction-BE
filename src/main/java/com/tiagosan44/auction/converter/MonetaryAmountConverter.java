package com.tiagosan44.auction.converter;



import com.tiagosan44.auction.domain.advanced.MonetaryAmount;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

	@Override
	public String convertToDatabaseColumn(final MonetaryAmount monetaryAmount) {
		return monetaryAmount.toString();
	}

	@Override
	public MonetaryAmount convertToEntityAttribute(final String s) {
		return MonetaryAmount.fromString(s);
	}
}
