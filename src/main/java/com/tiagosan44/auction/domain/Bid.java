package com.tiagosan44.auction.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiagosan44.auction.converter.MonetaryAmountConverter;
import com.tiagosan44.auction.domain.advanced.MonetaryAmount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bid
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_generator")
	@SequenceGenerator(name = "bid_generator", sequenceName = "bid_sequence")
	@Column(name = "bid_id")
	Long id;

	@NotNull
	@Convert(converter = MonetaryAmountConverter.class, disableConversion = false)
	@Column(name = "amount", length = 63)
	protected MonetaryAmount amount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", foreignKey=@ForeignKey(name = "bid_product_id_fk"))
	@JsonIgnore
	Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey=@ForeignKey(name = "bid_user_id_fk"))
	@JsonIgnore
	User user;
}
