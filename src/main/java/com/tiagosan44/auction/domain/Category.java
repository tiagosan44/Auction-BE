package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Getter
@Setter
@Entity
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
	@SequenceGenerator(name = "category_generator", sequenceName = "category_sequence")
	@Column(name = "category_id")
	private short id;

	@Size(max = 50)
	@Column(length = 50)
	private String name;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private com.tiagosan44.auction.domain.Category parent;

	@OneToMany(mappedBy = "parent")
	private Set<Category> subcategories;
}
