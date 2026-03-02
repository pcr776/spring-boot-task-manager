package es.pedro.taskmanager.domain.model;

import java.time.Instant;
import java.util.Objects;

/**
 * Entidad de dominio que representa una tarea.
 * Modelo inmutable: no expone setters.
 */
public class Task {

    // Puede ser null antes de persistir por primera vez.
    private final Long id;
    private final String title;
    private final String description;
    private final TaskStatus status;
    private final Instant createdAt;

    public Task(Long id, String title, String description, TaskStatus status, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }

    /**
     * Devuelve una nueva tarea con el id indicado.
     * Se usa cuando persistencia genera el id al guardar.
     */
    public Task withId(Long newId) {
        return new Task(newId, this.title, this.description, this.status, this.createdAt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        // La identidad de negocio se basa en el id.
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        // Debe mantenerse consistente con equals.
        return Objects.hash(id);
    }
}
