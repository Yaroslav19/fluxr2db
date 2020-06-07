package com.opu.fluxr2db.controller;

import com.opu.fluxr2db.domain.Task;
import com.opu.fluxr2db.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public Mono<Task> getAll(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @GetMapping
    public Flux<Task> getAll(@RequestParam(defaultValue = "0") Long start, @RequestParam(defaultValue = "3") Long count) {
        return taskService.getAll(start, count);
    }

    @PostMapping
    public Mono<Task> create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}")
    public Mono<Task> update(@PathVariable Long id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return taskService.deleteById(id);
    }
}