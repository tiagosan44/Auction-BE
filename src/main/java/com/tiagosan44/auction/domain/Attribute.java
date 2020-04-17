package com.tiagosan44.auction.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attribute {

    @Id
    @GeneratedValue(generator = "attribute_generator")
    @SequenceGenerator(name = "attribute_generator", sequenceName = "attribute_sequence", initialValue = 1000)
    @Column(name = "attribute_id")
    Long id;

    @Size(max = 50)
    @Column(columnDefinition = "text", length = 50)
    String name;

    @Size(max = 200)
    @Column(columnDefinition = "text", length = 200)
    String description;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<AttributeValue> values;
}
