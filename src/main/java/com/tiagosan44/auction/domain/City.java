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
public class City {

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "city_id")
	Short id;

	@NotBlank
	String city;

	String code;

    String zipCode;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Address> addresses;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", foreignKey=@ForeignKey(name = "city_state_id_fk"))
    State state;
}
