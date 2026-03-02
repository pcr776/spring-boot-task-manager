package es.pedro.taskmanager.infrastructure.persistence.adapter;

import es.pedro.taskmanager.application.port.out.TaskRepositoryPort;
import es.pedro.taskmanager.domain.model.Task;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Adaptador de infraestructura que implementa el puerto de repositorio en memoria.
 * Util para desarrollo y pruebas sin base de datos real.
 */
@Component
public class InMemoryTaskRepositoryAdapter implements TaskRepositoryPort {

    // Almacenamiento en memoria seguro para concurrencia basica.
    private final Map<Long, Task> store = new ConcurrentHashMap<>();
    // Generador incremental de ids para tareas nuevas.
    private final AtomicLong sequence = new AtomicLong(0);

    /**
     * Guarda la tarea; si no trae id, asigna uno nuevo.
     */
    @Override
    public Task save(Task task) {
        Long id = task.getId();
        if (id == null) {
            id = sequence.incrementAndGet();
            task = task.withId(id);
        }
        store.put(id, task);
        return task;
    }

    /**
     * Busca una tarea por id.
     */
    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * Devuelve una copia de las tareas almacenadas.
     */
    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }
}