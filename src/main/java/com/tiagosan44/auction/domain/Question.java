package com.tiagosan44.auction.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question extends AbstractAuditingEntity {

    @Id
	@GeneratedValue(generator = "question_generator")
	@SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", initialValue = 1000)
	@Column(name = "question_id")
	Long id;

	@NotBlank
	@Size(min = 3, max = 100)
	String title;

	@Column(columnDefinition = "text")
	String description;
}
