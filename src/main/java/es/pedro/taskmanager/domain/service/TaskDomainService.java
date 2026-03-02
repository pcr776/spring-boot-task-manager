package es.pedro.taskmanager.domain.service;

/**
 * Servicio de dominio con reglas de validación de tareas.
 */
public class TaskDomainService {

    /**
     * Valida el título: obligatorio y con longitud máxima de 100.
     */
    public void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        if (title.length() > 100) {
            throw new IllegalArgumentException("title max length is 100");
        }
    }

    /**
     * Valida la descripción: opcional, con longitud máxima de 500.
     */
    public void validateDescription(String description) {
        if (description != null && description.length() > 500) {
            throw new IllegalArgumentException("description max length is 500");
        }
    }
}
