package es.pedro.taskmanager.infrastructure.persistence.adapter;

import es.pedro.taskmanager.application.port.out.TaskRepositoryPort;
import es.pedro.taskmanager.domain.model.Task;
import es.pedro.taskmanager.infrastructure.persistence.entity.TaskEntity;
import es.pedro.taskmanager.infrastructure.persistence.repository.SpringDataTaskRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia que conecta el puerto de repositorio con Spring Data JPA.
 */
@Component
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final SpringDataTaskRepository repository;

    public TaskRepositoryAdapter(SpringDataTaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Guarda la tarea en BD y devuelve la version persistida.
     */
    @Override
    public Task save(Task task) {
        TaskEntity entity = toEntity(task);
        TaskEntity saved = repository.save(entity);
        return toDomain(saved);
    }

    /**
     * Busca una tarea por id y la convierte a dominio si existe.
     */
    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    /**
     * Recupera todas las tareas de BD y las convierte a dominio.
     */
    @Override
    public List<Task> findAll() {
        return repository.findAll().stream().map(this::toDomain).toList();
    }

    /**
     * Mapea el modelo de dominio a entidad JPA.
     */
    private TaskEntity toEntity(Task task) {
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }

    /**
     * Mapea la entidad JPA al modelo de dominio.
     */
    private Task toDomain(TaskEntity entity) {
        return new Task(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getCreatedAt()
        );
    }
}
