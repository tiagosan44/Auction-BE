package com.tiagosan44.auction.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Persist AuditEvent managed by the Spring Boot actuator.
 *
 * @see org.springframework.boot.actuate.audit.AuditEvent
 */
@Getter
@Setter
@Entity
@ToString
@Table(name = "persistent_audit_event")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersistentAuditEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "event_id")
    Long id;

    @NotNull
    @Column(nullable = false)
    String principal;

    @Column(name = "event_date")
    Instant auditEventDate;

    @Column(name = "event_type")
    String auditEventType;

    @ElementCollection
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(name = "persistent_audit_evt_data", joinColumns=@JoinColumn(name="event_id"))
    Map<String, String> data = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersistentAuditEvent)) {
            return false;
        }
        return id != null && id.equals(((PersistentAuditEvent) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
