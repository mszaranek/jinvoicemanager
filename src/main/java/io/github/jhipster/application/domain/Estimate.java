package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.jhipster.application.domain.views.Views;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "jhi_estimate")
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    @JsonIgnore
    private Long id;
    @ManyToOne
    //@JsonView(Views.InvoiceCreationFirstStepView.class)
    @JsonIgnore
    private User user;
    @ManyToOne
    @JsonIgnore
    private Task task;
    @JsonView(Views.InvoiceCreationFirstStepView.class)

    private Integer value;

    public Estimate(User user, Task task, Integer value){
        this.user=user;
        this.task=task;
        this.value=value;
    }

    public Estimate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estimate estimate = (Estimate) o;
        return Objects.equals(id, estimate.id) &&
            Objects.equals(user, estimate.user) &&
            Objects.equals(task, estimate.task) &&
            Objects.equals(value, estimate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, task, value);
    }

    @Override
    public String toString() {
        return "Estimate{" +
            "id=" + id +
            ", user=" + user.getLogin() +
            ", task=" + task.getNumber() +
            ", value=" + value +
            '}';
    }


}
