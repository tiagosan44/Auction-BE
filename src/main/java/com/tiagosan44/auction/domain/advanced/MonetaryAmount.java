package com.tiagosan44.auction.domain.advanced;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED, makeFinal = true)
public class MonetaryAmount implements Serializable {

	BigDecimal value;
	Currency currency;

	public BigDecimal getValue() {
		return value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public boolean equals(Object o) { if (this == o) return true;
		if (!(o instanceof MonetaryAmount)) return false;
		final MonetaryAmount monetaryAmount = (MonetaryAmount) o;
		if (!value.equals(monetaryAmount.value)) return false;
		if (!currency.equals(monetaryAmount.currency)) return false;
		return true;
	}

	public int hashCode() {
		int result;
		result = value.hashCode();
		result = 29 * result + currency.hashCode();
		return result;
	}

	public String toString() {
		return getValue() + " " + getCurrency();
	}

	public static MonetaryAmount fromString(String s) {
		String[] split = s.split(" ");
		return new MonetaryAmount(
				new BigDecimal(split[0]),
				Currency.getInstance(split[1])
		);
	}
}
