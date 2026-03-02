package es.pedro.taskmanager.application.port.out;

/**
 * Puerto de salida (port/out) para persistencia de tareas.
 * Va en port/out porque la aplicación lo usa para "salir" a infraestructura
 * (base de datos, servicios externos, etc.) sin acoplarse a una implementación concreta.
 */
import es.pedro.taskmanager.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {

    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();
}