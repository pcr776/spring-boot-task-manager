package es.pedro.taskmanager.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//test rápido de que todo está bien montado.
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}