package com.artursl.tasks_tracker.repositories;

import com.artursl.tasks_tracker.domain.entities.Columnn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ColumnRepository extends JpaRepository<Columnn, UUID> {
}
