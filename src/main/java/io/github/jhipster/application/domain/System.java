package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.jhipster.application.domain.views.Views;
import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@JsonIgnoreProperties(ignoreUnknown=true)
//@Table(name = "jhi_system")
public class System {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    private Long id;
    @JsonView({Views.UsersTaskView.class, Views.InvoiceCreationThirdStepView.class, Views.TaskView.class})
    private String name;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "system")
    @JsonIgnore
    private Set<Task> tasks = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "project_system", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "system_id"))
    @JsonIgnore
    private Set<Project> projects = new HashSet<>();

    public System() {

    }

    public System(String name, Set<Task> tasks, Set<Project> projects) {
        this.name = name;
        this.tasks = tasks;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        System system = (System) o;
        return Objects.equals(id, system.id) &&
            Objects.equals(name, system.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
