package es.pedro.taskmanager.application.service;

import es.pedro.taskmanager.application.port.in.CreateTaskUseCase;
import es.pedro.taskmanager.application.port.in.GetTaskUseCase;
import es.pedro.taskmanager.application.port.in.ListTasksUseCase;
import es.pedro.taskmanager.application.port.out.TaskRepositoryPort;
import es.pedro.taskmanager.domain.model.Task;
import es.pedro.taskmanager.domain.model.TaskStatus;
import es.pedro.taskmanager.domain.service.TaskDomainService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de aplicacion que orquesta casos de uso de tareas.
 * Implementa puertos de entrada (port/in) y delega persistencia al puerto de salida (port/out).
 */
@Service
public class TaskService implements CreateTaskUseCase, GetTaskUseCase, ListTasksUseCase {

    // Dependencia de salida hacia persistencia (infraestructura).
    private final TaskRepositoryPort taskRepository;
    // Reglas de negocio puras del dominio.
    private final TaskDomainService domainService;

    public TaskService(TaskRepositoryPort taskRepository) {
        this.taskRepository = taskRepository;
        // Instancia directa al no requerir estado ni dependencias externas.
        this.domainService = new TaskDomainService();
    }

    /**
     * Valida datos de entrada, crea la tarea en estado inicial y la persiste.
     */
    @Override
    public Task create(String title, String description) {
        domainService.validateTitle(title);
        domainService.validateDescription(description);

        Task task = new Task(
                null,
                title.trim(),
                description,
                TaskStatus.PENDING,
                Instant.now()
        );

        return taskRepository.save(task);
    }

    /**
     * Recupera una tarea por id.
     */
    @Override
    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    /**
     * Lista todas las tareas disponibles.
     */
    @Override
    public List<Task> listAll() {
        return taskRepository.findAll();
    }
}