package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
//@Table(name = "jhi_proj_role")
public class ProjRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    private Long id;
    private String roleName;
    @OneToMany
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "project_proj_role", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "proj_role_id"))
    private Set<Project> projects;

    public ProjRole() {

    }

    public ProjRole(String roleName, Set<User> users, Set<Project> projects) {
        this.roleName = roleName;
        this.users = users;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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
        ProjRole projRole = (ProjRole) o;
        return Objects.equals(id, projRole.id) &&
            Objects.equals(roleName, projRole.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName);
    }
}
