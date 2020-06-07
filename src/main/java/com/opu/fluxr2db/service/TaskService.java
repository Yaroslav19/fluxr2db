package com.opu.fluxr2db.service;

import com.opu.fluxr2db.domain.Task;
import com.opu.fluxr2db.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;

    public Mono<Task> getById(long id) {
        return taskRepo.findById(id);
    }

    public Flux<Task> getAll(Long start, Long count) {
        return taskRepo.findAll()
                .skip(start)
                .take(count);
    }

    public Mono<Task> create(Task task) {
        return taskRepo.save(task);
    }

    public Mono<Task> update(Long id, Task task) {
        task.setId(id);
        return taskRepo.save(task);
    }

    public Mono<Void> deleteById(long id) {
        return taskRepo.deleteById(id);
    }
}