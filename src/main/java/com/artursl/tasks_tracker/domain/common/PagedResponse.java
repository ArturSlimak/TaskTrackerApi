package com.artursl.tasks_tracker.domain.common;

import java.util.List;

public record PagedResponse<T>(
        List<T> items,
        int page,
        int size,
        int count,
        long totalElements,
        int totalPages
) {
}
