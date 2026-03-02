# Spring Boot Task Manager (Hexagonal Architecture)

Learning project to practice building a REST API with Spring Boot using a simplified Hexagonal Architecture (ports & adapters).

The goal is to understand how to structure a backend application by clearly separating:
- Domain logic
- Application use cases
- Infrastructure adapters

---

## Tech

- Java 21
- Spring Boot
- Maven
- H2 (in-memory, planned for persistence phase)

---

## Current Implementation

✔ Domain model (`Task`, `TaskStatus`)  
✔ Domain service for business rules  
✔ Application layer:
- Use case interfaces (`CreateTaskUseCase`, `GetTaskUseCase`, `ListTasksUseCase`)
- Repository port (`TaskRepositoryPort`)
- Application service (`TaskService`)
  ✔ In-memory repository adapter (temporary implementation)

Pending:
- REST controller (HTTP layer)
- JPA persistence with H2
- DTOs and request/response mapping

---

## Architecture Overview

This project follows a simplified Hexagonal Architecture:

- **domain** → business model and domain services
- **application** → use cases and ports (in/out)
- **infrastructure** → adapters (REST, persistence)

The objective is to keep business logic independent from frameworks and external technologies.

---

## Roadmap (learning iterations)

- Iteration 1: Create / Get by id / List tasks (in-memory + H2)
- Iteration 2: Validation + error handling + basic tests
- Iteration 3: Migrate H2 → Postgres (profiles, optional Docker)
- Iteration 4 (optional): Basic security

---

## Status

Work in progress – currently implementing the core application layer.