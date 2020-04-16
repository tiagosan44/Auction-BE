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
public class State {

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "state_id")
	private Short id;

	private String state;

	private String code;

	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<City> cities;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
    Country country;
}
