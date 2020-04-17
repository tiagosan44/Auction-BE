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
public class State {

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "state_id")
	Short id;

	@NotBlank
	String state;

	String code;

	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<City> cities;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
    Country country;
}
