package com.artursl.tasks_tracker.domain.dtos;

import java.util.List;

public record ListResponse<T>(
        List<T> items,
        int count
) {
    public ListResponse(List<T> items) {
        this(items, items != null ? items.size() : 0);
    }
}