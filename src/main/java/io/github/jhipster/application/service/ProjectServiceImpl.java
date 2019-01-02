package io.github.jhipster.application.service;

import com.querydsl.jpa.impl.JPAQuery;
import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.repository.ProjectRepository;
import io.github.jhipster.application.service.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

//@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final EntityManager entityManager;

    public ProjectServiceImpl(ProjectRepository projectRepository, EntityManager entityManager) {
        this.projectRepository = projectRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Set<Project> getProjects() {
        return new HashSet<>(projectRepository.findAll());
    }

    @Override
    public void createProject(Project project) {
        project.setId(null);
        projectRepository.save(project);
    }

    @Override
    public Project findProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow((() -> new NotFoundException("Project not found")));
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.delete(projectRepository.findById(id)
                .orElseThrow((() -> new NotFoundException("Project not found"))));
    }

    @Override
    public Set<Task> getTasks(Long id) {
        JPAQuery<Task> query = new JPAQuery<>(entityManager);
        QProject qProject = QProject.project;
        QSystem qSystem = QSystem.system;
        QTask qTask = QTask.task;

        return new HashSet<>(query
                .from(qTask)
                .join(qTask.system, qSystem)
                .on(qTask.system.id.eq(qSystem.id))
                .join(qSystem.projects, qProject)
                .on(qSystem.projects.any().id.eq(qProject.id))
                .where(qProject.id.eq(id))
                .fetch());
    }
}
