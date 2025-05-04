package com.artursl.tasks_tracker.domain.common;

import java.util.List;

public record ListResponse<T>(
        List<T> items,
        int count
) {
}
