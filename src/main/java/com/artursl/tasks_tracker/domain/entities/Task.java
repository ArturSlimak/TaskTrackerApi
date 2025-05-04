package com.artursl.tasks_tracker.domain.entities;

import com.artursl.tasks_tracker.domain.common.Auditable;
import com.artursl.tasks_tracker.domain.common.AuditingEntityListener;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tasks")
public class Task  implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    private TaskPriority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "column_id")
    private Columnn column;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    public Task() {
    }

    public Task(UUID id, String title, String description, TaskPriority priority, Columnn column, Board board, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.column = column;
        this.board = board;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Columnn getColumn() {
        return column;
    }

    public void setColumn(Columnn column) {
        this.column = column;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && priority == task.priority && Objects.equals(column, task.column) && Objects.equals(board, task.board) && Objects.equals(createdAt, task.createdAt) && Objects.equals(updatedAt, task.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, priority, column, board, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", column=" + column +
                ", board=" + board +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
