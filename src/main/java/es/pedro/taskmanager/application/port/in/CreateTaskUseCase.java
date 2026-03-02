package es.pedro.taskmanager.application.port.in;

import es.pedro.taskmanager.domain.model.Task;

/**
 * Puerto de entrada (port/in) para el caso de uso "crear tarea".
 * Va en port/in porque marca cómo actores externos solicitan crear tareas.
 */
public interface CreateTaskUseCase {
    /**
     * Crea una tarea con los datos de entrada.
     */
    Task create(String title, String description);
}
