package com.tiagosan44.auction.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Question extends AbstractAuditingEntity {

    @Id
	@GeneratedValue(generator = "question_generator")
	@SequenceGenerator(
			name = "question_generator",
			sequenceName = "question_sequence",
			initialValue = 1000
	)
	@Column(name = "question_id")
	private Long id;

	@NotBlank
	@Size(min = 3, max = 100)
	private String title;

	@Column(columnDefinition = "text")
	private String description;
}
