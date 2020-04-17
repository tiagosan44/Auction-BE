package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttributeValue {

    @Id
    @GeneratedValue(generator = "attribute_value_generator")
    @SequenceGenerator(name = "attribute_value_generator", sequenceName = "attribute_value_sequence", initialValue = 1000)
    @Column(name = "attribute_value_id")
    Long id;

    @Size(max = 50)
    @Column(columnDefinition = "text", length = 50)
    String name;

    @Size(max = 200)
    @Column(columnDefinition = "text", length = 200)
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id")
    @JsonIgnore
    Attribute attribute;
}
