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
	@JoinColumn(name = "user_id",
        foreignKey=@ForeignKey(name = "user_image_user_id_fk"))
	User user;

}
