package es.pedro.taskmanager.infrastructure.controller.dto;

import es.pedro.taskmanager.domain.model.Task;
import es.pedro.taskmanager.domain.model.TaskStatus;

import java.time.Instant;

/**
 * DTO de salida expuesto por la API para representar una tarea.
 */
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Instant createdAt;

    public TaskResponse(Long id, String title, String description, TaskStatus status, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    /**
     * Convierte una entidad de dominio en su representacion de respuesta HTTP.
     */
    public static TaskResponse fromDomain(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }

    /** @return identificador de la tarea. */
    public Long getId() { return id; }
    /** @return titulo de la tarea. */
    public String getTitle() { return title; }
    /** @return descripcion de la tarea. */
    public String getDescription() { return description; }
    /** @return estado actual de la tarea. */
    public TaskStatus getStatus() { return status; }
    /** @return fecha de creacion de la tarea. */
    public Instant getCreatedAt() { return createdAt; }
}
