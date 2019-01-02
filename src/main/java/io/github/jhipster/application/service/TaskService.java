package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface TaskService {

    void saveTasks(Set<Task> tasks);

    Page<Task> getTasksForEstimation(Long userId, Pageable pageable);

    void addEstimate(Long taskId, Long userId, Integer value);
}
