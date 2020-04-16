package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Answer extends AbstractAuditingEntity {

	@Id
	@GeneratedValue(generator = "answer_generator")
	@SequenceGenerator(
			name = "answer_generator",
			sequenceName = "answer_sequence",
			initialValue = 1000
	)
	@Column(name = "answer_id")
	private Long id;

	@Column(columnDefinition = "text")
	private String text;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "question_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private com.tiagosan44.auction.domain.Question question;
}
