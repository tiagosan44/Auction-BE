package com.tiagosan44.auction.domain;


import com.tiagosan44.auction.converter.MonetaryAmountConverter;
import com.tiagosan44.auction.domain.advanced.MonetaryAmount;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product
{
	@Id
	@Column(name = "product_id")
	@GeneratedValue(generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "product_sequence", initialValue = 1000)
	private Long id;

	@NotNull
	@Size(max = 50)
	@Column(length = 50)
	private String name;

	@NotNull
	@Convert(
			converter = MonetaryAmountConverter.class,
			disableConversion = false
	)
	@Column(name = "price", length = 63)
	protected MonetaryAmount price;

	@OneToMany(mappedBy = "product")
	private Set<com.tiagosan44.auction.domain.Bid> bids;
}
