package com.tiagosan44.auction.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiagosan44.auction.converter.MonetaryAmountConverter;
import com.tiagosan44.auction.domain.advanced.MonetaryAmount;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
public class Bid
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_generator")
	@SequenceGenerator(name = "bid_generator", sequenceName = "bid_sequence")
	@Column(name = "bid_id")
	private short id;

	@NotNull
	@Convert(
			converter = MonetaryAmountConverter.class,
			disableConversion = false
	)
	@Column(name = "amount", length = 63)
	protected MonetaryAmount amount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
}
