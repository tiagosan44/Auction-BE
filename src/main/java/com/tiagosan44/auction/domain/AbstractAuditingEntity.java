package com.tiagosan44.auction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Base abstract class for entities which will hold definitions for created, last modified, created by,
 * last modified by attributes.
 */
@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    @JsonIgnore
    String createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    Instant createdDate = Instant.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    @JsonIgnore
    String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    Instant lastModifiedDate = Instant.now();
}
