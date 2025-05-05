package com.artursl.tasks_tracker.mappers;

import com.artursl.tasks_tracker.domain.dtos.ListResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface CommonMappers {
    default <T, R> ListResponse<R> mapListToListResponse(List<T> list, Function<T, R> mapper) {
        if (list == null) return new ListResponse<>(List.of());
        var items = list.stream().map(mapper).collect(Collectors.toList());
        return new ListResponse<>(items);
    }
}
