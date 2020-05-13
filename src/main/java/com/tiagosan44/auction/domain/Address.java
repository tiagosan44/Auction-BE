package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
	@SequenceGenerator(name = "address_generator", sequenceName = "address_sequence")
	@Column(name = "address_id")
	Long id;

    @NotBlank
    @Size(min = 3, max = 100)
	String address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", foreignKey=@ForeignKey(name = "address_city_id_fk"))
	City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey=@ForeignKey(name = "address_user_id_fk"))
	@JsonIgnore
	User user;
}
