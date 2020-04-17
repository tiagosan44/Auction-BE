package com.tiagosan44.auction.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Immutable
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "country_id")
	Short id;

	@NotBlank
	String country;

	String code;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<State> states;
}
