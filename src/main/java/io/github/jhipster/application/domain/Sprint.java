package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
//@Table(name = "jhi_sprint")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    private Long id;
    private Double amount;
    private Date startDate;
    private Date finishDate;
    @OneToMany
    private Set<Task> tasks = new HashSet<>();

    public Sprint() {

    }

    public Sprint(Double amount, Date startDate, Date finishDate, Set<Task> tasks) {
        this.amount = amount;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sprint sprint = (Sprint) o;
        return Objects.equals(id, sprint.id) &&
            Objects.equals(amount, sprint.amount) &&
            Objects.equals(startDate, sprint.startDate) &&
            Objects.equals(finishDate, sprint.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, startDate, finishDate);
    }
}
