package es.pedro.taskmanager.infrastructure.controller;

import es.pedro.taskmanager.application.port.in.CreateTaskUseCase;
import es.pedro.taskmanager.application.port.in.GetTaskUseCase;
import es.pedro.taskmanager.application.port.in.ListTasksUseCase;
import es.pedro.taskmanager.domain.model.Task;
import es.pedro.taskmanager.infrastructure.controller.dto.CreateTaskRequest;
import es.pedro.taskmanager.infrastructure.controller.dto.TaskResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operaciones de lectura y creacion de tareas.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final ListTasksUseCase listTasksUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase,
                          GetTaskUseCase getTaskUseCase,
                          ListTasksUseCase listTasksUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskUseCase = getTaskUseCase;
        this.listTasksUseCase = listTasksUseCase;
    }

    /**
     * Crea una nueva tarea a partir del JSON recibido en el cuerpo de la peticion.
     */
    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody CreateTaskRequest request) {

        Task task = createTaskUseCase.create(
                request.getTitle(),
                request.getDescription()
        );

        return ResponseEntity.ok(TaskResponse.fromDomain(task));
    }

    /**
     * Devuelve una tarea por id o 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getById(@PathVariable Long id) {
        return getTaskUseCase.getById(id)
                .map(task -> ResponseEntity.ok(TaskResponse.fromDomain(task)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Lista todas las tareas y las convierte a DTO de respuesta.
     */
    @GetMapping
    public ResponseEntity<List<TaskResponse>> listAll() {
        List<TaskResponse> response = listTasksUseCase.listAll()
                .stream()
                .map(TaskResponse::fromDomain)
                .toList();

        return ResponseEntity.ok(response);
    }
}
