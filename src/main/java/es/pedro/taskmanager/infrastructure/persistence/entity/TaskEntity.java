package es.pedro.taskmanager.infrastructure.persistence.entity;

import es.pedro.taskmanager.domain.model.TaskStatus;
import jakarta.persistence.*;

import java.time.Instant;

/**
 * Entidad JPA que representa la tabla `tasks` en la base de datos.
 */
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TaskStatus status;

    @Column(nullable = false)
    private Instant createdAt;

    public TaskEntity() {
        // Constructor vacio requerido por JPA.
    }

    public TaskEntity(Long id, String title, String description, TaskStatus status, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    /** @return identificador persistido en BD. */
    public Long getId() { return id; }
    /** @return titulo de la tarea. */
    public String getTitle() { return title; }
    /** @return descripcion de la tarea. */
    public String getDescription() { return description; }
    /** @return estado almacenado. */
    public TaskStatus getStatus() { return status; }
    /** @return fecha de creacion almacenada. */
    public Instant getCreatedAt() { return createdAt; }

    /** Actualiza id (normalmente gestionado por JPA). */
    public void setId(Long id) { this.id = id; }
    /** Actualiza el titulo de la tarea. */
    public void setTitle(String title) { this.title = title; }
    /** Actualiza la descripcion de la tarea. */
    public void setDescription(String description) { this.description = description; }
    /** Actualiza el estado de la tarea. */
    public void setStatus(TaskStatus status) { this.status = status; }
    /** Actualiza la fecha de creacion. */
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
