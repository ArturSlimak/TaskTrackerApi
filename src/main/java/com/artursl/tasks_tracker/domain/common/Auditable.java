package com.artursl.tasks_tracker.domain.common;

import java.time.OffsetDateTime;

public interface Auditable {
    void setCreatedAt(OffsetDateTime createdAt);
    void setUpdatedAt(OffsetDateTime updatedAt);
}
