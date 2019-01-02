package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.jhipster.application.domain.views.Views;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Entity
@Audited
@Builder
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "number")
@NamedEntityGraph(name="taskEntityGraph", attributeNodes={
        @NamedAttributeNode("users"),
        @NamedAttributeNode("sprint"),
        @NamedAttributeNode("system")
})
@JsonIgnoreProperties(ignoreUnknown=true)
//@Table(name = "jhi_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    private Long id;
    @JsonView({Views.UserView.class, Views.UsersTaskView.class,Views.InvoiceCreationThirdStepView.class,Views.InvoiceView.class, Views.TaskView.class})
    private String number;
    @JsonView({Views.UserView.class, Views.UsersTaskView.class,Views.InvoiceCreationThirdStepView.class,Views.InvoiceView.class, Views.TaskView.class})
    private String summary;
    @ManyToMany
    @JsonView({Views.ProjectsTaskView.class,Views.InvoiceCreationSecondStepView.class})
    @NotAudited
    private Set<User> users;
    @JsonView({Views.UsersTaskView.class,Views.InvoiceCreationThirdStepView.class,Views.InvoiceView.class, Views.TaskView.class})
    private Integer estimate;
    @JsonView(Views.UsersTaskView.class)
    private Date startDate;
    @JsonView(Views.UsersTaskView.class)
    private Date finishDate;
    @JsonView({Views.UsersTaskView.class,Views.InvoiceCreationThirdStepView.class,Views.InvoiceView.class, Views.TaskView.class})
    private String dueDate;

    @JsonView({Views.UsersTaskView.class,Views.InvoiceCreationThirdStepView.class,Views.InvoiceView.class})
    private String status;
    @JsonView({Views.UsersTaskView.class,Views.InvoiceCreationThirdStepView.class,Views.InvoiceView.class})
    private String type;
    @ManyToOne
    @NotAudited
    private Sprint sprint;
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JsonView({Views.UsersTaskView.class, Views.InvoiceCreationThirdStepView.class,Views.InvoiceView.class, Views.TaskView.class})
    @NotAudited
    @JsonIgnore
    private System system;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "task")
    @NotAudited
    @JsonView(Views.InvoiceCreationFirstStepView.class)
    private Set<Estimate> estimates;

    @NotAudited
    private String trelloId;

    @Formula("regexp_replace(number,'[^0-9]+','') ::integer")
    @NotAudited
    @JsonView({Views.UserView.class, Views.UsersTaskView.class,Views.InvoiceCreationThirdStepView.class})
    private Long unsigned;

    @Formula("regexp_replace(number,'[0-9]+','')")
    @NotAudited
    @JsonView({Views.UserView.class, Views.UsersTaskView.class,Views.InvoiceCreationThirdStepView.class})
    private String textPart;

    public Task(String number, String summary, Set<User> users, Integer estimate, Date startDate, Date finishDate, String dueDate, String status, String type, Sprint sprint, System system, Set<Estimate> estimates, String trelloId, Long unsigned, String textPart) {
        this.number = number;
        this.summary = summary;
        this.users = users;
        this.estimate = estimate;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.dueDate = dueDate;
        this.status = status;
        this.type = type;
        this.sprint = sprint;
        this.system = system;
        this.estimates = estimates;
        this.trelloId = trelloId;
        this.unsigned = unsigned;
        this.textPart = textPart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Set<Estimate> getEstimates() {
        return estimates;
    }

    public void setEstimates(Set<Estimate> estimates) {
        this.estimates = estimates;
    }

    public String getTrelloId() {
        return trelloId;
    }

    public void setTrelloId(String trelloId) {
        this.trelloId = trelloId;
    }

    public Long getUnsigned() {
        return unsigned;
    }

    public void setUnsigned(Long unsigned) {
        this.unsigned = unsigned;
    }

    public String getTextPart() {
        return textPart;
    }

    public void setTextPart(String textPart) {
        this.textPart = textPart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
            Objects.equals(number, task.number) &&
            Objects.equals(summary, task.summary) &&
            Objects.equals(estimate, task.estimate) &&
            Objects.equals(startDate, task.startDate) &&
            Objects.equals(finishDate, task.finishDate) &&
            Objects.equals(dueDate, task.dueDate) &&
            Objects.equals(status, task.status) &&
            Objects.equals(type, task.type) &&
            Objects.equals(sprint, task.sprint) &&
            Objects.equals(system, task.system) &&
            Objects.equals(trelloId, task.trelloId) &&
            Objects.equals(unsigned, task.unsigned) &&
            Objects.equals(textPart, task.textPart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, summary, estimate, startDate, finishDate, dueDate, status, type, sprint, system, trelloId, unsigned, textPart);
    }
}
