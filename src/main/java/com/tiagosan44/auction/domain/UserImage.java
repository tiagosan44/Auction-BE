package com.tiagosan44.auction.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserImage
{
	@Id
	@Column(name = "user_id")
	Long id;

	@NotNull
	String fileName;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	User user;

}
