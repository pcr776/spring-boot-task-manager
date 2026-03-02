package es.pedro.taskmanager.application.port.in;

import es.pedro.taskmanager.domain.model.Task;

import java.util.List;

/**
 * Puerto de entrada (port/in) para el caso de uso "listar tareas".
 * Va en port/in porque expone operaciones que inician desde fuera (API, UI, CLI).
 */
public interface ListTasksUseCase {
    /**
     * Devuelve todas las tareas.
     */
    List<Task> listAll();
}
