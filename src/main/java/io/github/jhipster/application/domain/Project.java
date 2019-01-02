package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.jhipster.application.domain.views.Views;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "name")
@JsonIgnoreProperties(ignoreUnknown=true)
//@Table(name = "jhi_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    private Long id;
    @JsonView({Views.UserView.class,Views.UsersProjectsView.class})
    private String name;
    private Double monthlyCost;
    private String status;

    @ManyToMany(cascade = {CascadeType.MERGE}, mappedBy = "projects")
    @JsonIgnore
    private Set<User> users = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE}, mappedBy = "projects")
    @JsonIgnore
    private Set<System> systems = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE}, mappedBy = "projects")
    @JsonIgnore
    private Set<Invoice> invoices = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.MERGE}, mappedBy = "projects")
    @JsonIgnore
    private Set<ProjRole> projRoles = new HashSet<>();

    public Project() {

    }

    public Project(String name, Double monthlyCost, String status, Set<User> users, Set<System> systems, Set<Invoice> invoices, Set<ProjRole> projRoles) {
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.status = status;
        this.users = users;
        this.systems = systems;
        this.invoices = invoices;
        this.projRoles = projRoles;
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

    public Double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(Double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<System> getSystems() {
        return systems;
    }

    public void setSystems(Set<System> systems) {
        this.systems = systems;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Set<ProjRole> getProjRoles() {
        return projRoles;
    }

    public void setProjRoles(Set<ProjRole> projRoles) {
        this.projRoles = projRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
            Objects.equals(name, project.name) &&
            Objects.equals(monthlyCost, project.monthlyCost) &&
            Objects.equals(status, project.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, monthlyCost, status);
    }
}
