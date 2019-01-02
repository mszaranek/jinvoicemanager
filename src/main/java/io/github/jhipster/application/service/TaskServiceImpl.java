package io.github.jhipster.application.service;

import com.fasterxml.jackson.annotation.JsonView;
import com.hazelcast.client.impl.protocol.task.queue.QueueClearMessageTask;
import com.querydsl.jpa.impl.JPAQuery;
import io.github.jhipster.application.domain.Estimate;
import io.github.jhipster.application.domain.QTask;
import io.github.jhipster.application.domain.QUser;
import io.github.jhipster.application.domain.Task;
import io.github.jhipster.application.domain.views.Views;
import io.github.jhipster.application.repository.EstimateRepository;
import io.github.jhipster.application.repository.TaskRepository;
import io.github.jhipster.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final EntityManager entityManager;
    private final UserRepository userRepository;
    private final EstimateRepository estimateRepository;

    public TaskServiceImpl(TaskRepository taskRepository, EntityManager entityManager, UserRepository userRepository, EstimateRepository estimateRepository) {
        this.taskRepository = taskRepository;
        this.entityManager = entityManager;
        this.userRepository = userRepository;
        this.estimateRepository = estimateRepository;
    }

    @Override
    public void saveTasks(Set<Task> tasks){
        taskRepository.saveAll(tasks);
    }

    @Override
    @JsonView(Views.TaskView.class)
    public Page<Task> getTasksForEstimation(Long userId, Pageable pageable){
        JPAQuery<Task> query = new JPAQuery<>(entityManager);
        QTask qTask = QTask.task;
        QUser qUser = QUser.user;
        List<Task> tasks = new ArrayList<>(query
                .from(qTask)
                .join(qTask.users, qUser)
                .where(qUser.in(qTask.users))
                .fetch());
        int start = (int) pageable.getOffset();
        int end =  (start + pageable.getPageSize()) > tasks.size() ? tasks.size() : (start + pageable.getPageSize());
        try {
            Page<Task> page = new PageImpl<>(tasks.subList(start, end), pageable, tasks.size());

            return page;
        }
        catch(IllegalArgumentException e){
            return null;
        }
    }

    @Override
    public void addEstimate(Long taskId, Long userId, Integer value){

        Estimate estimate;
        if(userRepository.findById(userId).get().getTasks().stream().anyMatch(task -> task.getEstimates().stream().anyMatch(estimate1 -> estimate1.getUser().getId()==userId))){
            estimate = estimateRepository.findByUserAndTask(userRepository.findById(userId).get(),taskRepository.findById(taskId).get()).get();
            estimate.setValue(value);
        }
        else {
         estimate = new Estimate(userRepository.findById(userId).get(), taskRepository.findById(taskId).get(), value);
        }
        estimateRepository.save(estimate);
    }
}
