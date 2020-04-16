package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails
{
	@Id
	@Column(name = "billing_details_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_details_generator")
	@SequenceGenerator(name = "billing_details_generator", sequenceName = "billing_details_sequence", initialValue = 1000)
	private Short id;

	@Size(min = 4)
	private String owner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
}
