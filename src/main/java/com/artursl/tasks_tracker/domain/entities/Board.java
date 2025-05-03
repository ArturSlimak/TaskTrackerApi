package com.artursl.tasks_tracker.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "board" , cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Columnn> columns;

    @OneToMany(mappedBy = "column", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Task> tasks;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Board() {
    }

    public Board(UUID id, String name, List<Columnn> columns, List<Task> tasks, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.columns = columns;
        this.tasks = tasks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Columnn> getColumns() {
        return columns;
    }

    public void setColumns(List<Columnn> columns) {
        this.columns = columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(id, board.id) && Objects.equals(name, board.name) && Objects.equals(columns, board.columns) && Objects.equals(tasks, board.tasks) && Objects.equals(createdAt, board.createdAt) && Objects.equals(updatedAt, board.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, columns, tasks, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", columns=" + columns +
                ", tasks=" + tasks +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
