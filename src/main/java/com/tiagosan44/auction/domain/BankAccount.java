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
public class BankAccount extends BillingDetails
{
	@Size(max = 10, min = 10)
	@Column(length = 10)
	String account;

	@Size(min = 4)
	String bankName;
}

