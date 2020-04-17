package com.tiagosan44.auction.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "authorities")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authoritySequenceGenerator")
    @SequenceGenerator(name = "authoritySequenceGenerator", sequenceName = "authorities_sequence", allocationSize = 1)
    @Column(name = "authority_id")
    Short id;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    String authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Authority)) {
            return false;
        }
        return Objects.equals(authority, ((Authority) o).authority);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(authority);
    }
}
