package com.tiagosan44.auction.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
public class CreditCard extends com.tiagosan44.auction.domain.BillingDetails
{
	@Size(max = 10, min = 10)
	@Column(length = 10)
	private String number;

	@Column(precision = 2)
	private Short expireMonth;

	@Column(precision = 2)
	private Short expireYear;

	@Size(max = 3, min = 3)
	@Column(length = 3)
	private String cvv;
}
