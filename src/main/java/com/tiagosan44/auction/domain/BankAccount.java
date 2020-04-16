package com.tiagosan44.auction.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class BankAccount extends com.tiagosan44.auction.domain.BillingDetails
{
	@Size(max = 10, min = 10)
	@Column(length = 10)
	private String account;

	@Size(min = 4)
	private String bankName;
}

