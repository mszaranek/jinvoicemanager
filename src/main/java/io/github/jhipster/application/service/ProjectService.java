package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.Project;
import io.github.jhipster.application.domain.Task;

import java.util.Set;

public interface ProjectService {

    Set<Project> getProjects();

    void createProject(Project project);

    Project findProjectById(Long id);

    void updateProject(Project project);

    void deleteProject(Long id);

    Set<Task> getTasks(Long id);
}
