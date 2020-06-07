package com.opu.fluxr2db.repository;

import com.opu.fluxr2db.domain.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends ReactiveCrudRepository<Task, Long> {
}