package com.artursl.tasks_tracker.domain.common;


import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class AuditingEntityListener {
    @PrePersist
    public void prePersist(Object entity) {
        if(entity instanceof Auditable auditable) {
            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
            auditable.setUpdatedAt(now);
            auditable.setCreatedAt(now);
        }
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof Auditable auditable) {
            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
            auditable.setUpdatedAt(now);
        }
    }
}
