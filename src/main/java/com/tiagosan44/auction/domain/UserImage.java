package com.tiagosan44.auction.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
public class UserImage
{
	@Id
	@Column(name = "user_id")
	private Long id;

	@NotNull
	private String fileName;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

}
