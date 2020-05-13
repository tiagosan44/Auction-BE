package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BillingDetails
{
	@Id
	@Column(name = "billing_details_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_details_generator")
	@SequenceGenerator(name = "billing_details_generator", sequenceName = "billing_details_sequence", initialValue = 1000)
	Long id;

	@Size(min = 4)
	String owner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey=@ForeignKey(name = "billing_details_user_id_fk"))
	@JsonIgnore
	User user;
}
