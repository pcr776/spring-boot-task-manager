package es.pedro.taskmanager.infrastructure.persistence.repository;

import es.pedro.taskmanager.infrastructure.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio Spring Data con operaciones CRUD sobre {@link TaskEntity}.
 */
public interface SpringDataTaskRepository extends JpaRepository<TaskEntity, Long> {
}