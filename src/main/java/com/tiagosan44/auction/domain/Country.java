package com.tiagosan44.auction.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Immutable
public class Country {

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "country_id")
	private Short id;

	private String country;

	private String code;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<com.tiagosan44.auction.domain.State> states;
}
