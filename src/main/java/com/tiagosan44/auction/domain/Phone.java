package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneSequenceGenerator")
	@SequenceGenerator(name = "phoneSequenceGenerator", sequenceName = "phones_sequence")
	@Column(name = "phone_id")
	Long id;

	String areaCode;

	String countryCode;

	@NotBlank
	String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey=@ForeignKey(name = "phone_user_id_fk"))
	@JsonIgnore
	User user;
}
