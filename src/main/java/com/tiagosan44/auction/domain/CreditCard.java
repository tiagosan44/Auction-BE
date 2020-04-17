package com.tiagosan44.auction.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditCard extends BillingDetails
{
	@Size(max = 10, min = 10)
	@Column(length = 10)
	String number;

	@Column(precision = 2)
	Short expireMonth;

	@Column(precision = 2)
	Short expireYear;

	@Size(max = 3, min = 3)
	@Column(length = 3)
	String cvv;
}
