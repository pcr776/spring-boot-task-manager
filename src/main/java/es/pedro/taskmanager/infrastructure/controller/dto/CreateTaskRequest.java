package es.pedro.taskmanager.infrastructure.controller.dto;

/**
 * DTO de entrada para crear una tarea desde la API.
 */
public class CreateTaskRequest {

    private String title;
    private String description;

    public CreateTaskRequest() {
        // Constructor vacio requerido por Jackson para deserializar JSON.
    }

    /**
     * @return titulo enviado por el cliente.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return descripcion enviada por el cliente.
     */
    public String getDescription() {
        return description;
    }
}
