package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
	@SequenceGenerator(name = "category_generator", sequenceName = "category_sequence")
	@Column(name = "category_id")
	Long id;

	@NotBlank
	@Size(max = 50)
	@Column(length = 50)
	String name;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	Category parent;

	@OneToMany(mappedBy = "parent")
	Set<Category> subcategories;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "category_attribute",
        joinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "category_id")},
        inverseJoinColumns = {@JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id   ")})
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    Set<Attribute> attributes = new HashSet<>();
}
