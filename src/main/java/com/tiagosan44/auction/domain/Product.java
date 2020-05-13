package com.tiagosan44.auction.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tiagosan44.auction.converter.MonetaryAmountConverter;
import com.tiagosan44.auction.domain.advanced.MonetaryAmount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product
{
	@Id
	@Column(name = "product_id")
	@GeneratedValue(generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "product_sequence", initialValue = 1000)
	Long id;

	@NotNull
	@Size(max = 50)
	@Column(length = 50)
	String name;

	@NotNull
	@Convert(converter = MonetaryAmountConverter.class, disableConversion = false)
	@Column(name = "price", length = 63)
	protected MonetaryAmount price;

	@OneToMany(mappedBy = "product")
	Set<Bid> bids;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "product_categories",
        joinColumns = {@JoinColumn(name = "product_id", foreignKey=@ForeignKey(name = "product_categories_product_id_fk"))},
        inverseJoinColumns = {@JoinColumn(name = "category_id", foreignKey=@ForeignKey(name = "product_categories_category_id_fk"))})
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    Set<Category> categories = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "product_attribute_values",
        joinColumns = {@JoinColumn(name = "product_id", foreignKey=@ForeignKey(name = "product_attribute_values_product_id_fk"))},
        inverseJoinColumns = {@JoinColumn(name = "attribute_value_id", foreignKey=@ForeignKey(name = "product_attribute_values_attribute_value_id_fk"))})
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    Set<AttributeValue> attributeValues = new HashSet<>();
}
