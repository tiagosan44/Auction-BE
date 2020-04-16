package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "PHONE")
public class Phone
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneSequenceGenerator")
	@SequenceGenerator(name = "phoneSequenceGenerator", sequenceName = "phones_sequence")
	@Column(name = "phone_id")
	private Long id;

	private String areaCode;

	private String countryCode;

	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
}
