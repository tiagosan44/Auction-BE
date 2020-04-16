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
public class City {

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "city_id")
	private Short id;

	private String city;

	private String code;

	private  String zipCode;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<com.tiagosan44.auction.domain.Address> addresses;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")
    com.tiagosan44.auction.domain.State state;
}
