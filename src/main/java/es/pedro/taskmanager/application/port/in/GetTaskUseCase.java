package es.pedro.taskmanager.application.port.in;

import es.pedro.taskmanager.domain.model.Task;

import java.util.Optional;

/**
 * Puerto de entrada (port/in) para el caso de uso "obtener tarea".
 * Va en port/in porque define lo que el exterior puede pedir a la aplicación.
 */
public interface GetTaskUseCase {
    /**
     * Busca una tarea por id.
     */
    Optional<Task> getById(Long id);
}
