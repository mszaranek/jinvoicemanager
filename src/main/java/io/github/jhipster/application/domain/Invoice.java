package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.jhipster.application.domain.views.Views;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@JsonIgnoreProperties(ignoreUnknown=true)
//@Table(name = "jhi_invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    @JsonView({Views.InvoiceView.class,Views.InvoiceCreationFirstStepView.class})
    private Long id;
    @JsonView({Views.InvoiceView.class, Views.InvoiceCreationSecondStepView.class})
    private String number;
    @JsonView({Views.UserView.class, Views.InvoiceView.class})
    private Double amount;
    @ManyToOne
    @JsonBackReference(value = "user_invoice")
    @JsonView({Views.UserView.class,Views.InvoiceView.class})
    private User user;
    @JsonView({Views.UserView.class,Views.InvoiceView.class})
    private Boolean paid;
    @JsonView({Views.UserView.class,Views.InvoiceView.class})
    private String date;
    @JsonView({Views.UserView.class,Views.InvoiceView.class})
    private String validationStatus;

    @JsonView({Views.UserView.class,Views.InvoiceView.class, Views.InvoiceCreationFirstStepView.class})
    private String lifeCycleStatus;

    @JsonView({Views.UserView.class,Views.InvoiceView.class,Views.InvoiceCreationSecondStepView.class})
    private String currency;

    @JsonView({Views.UserView.class,Views.InvoiceView.class, Views.InvoiceCreationSecondStepView.class})
    private Long hours;

    @JsonView({Views.UserView.class,Views.InvoiceView.class,Views.InvoiceCreationSecondStepView.class})
    private Long vat;

    @JsonView({Views.UserView.class,Views.InvoiceView.class, Views.InvoiceCreationSecondStepView.class})
    private String payday;

    @JsonView({Views.InvoiceView.class,Views.InvoiceCreationThirdStepView.class})
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Task> tasks;

    @JsonView({Views.UserView.class,Views.InvoiceView.class, Views.InvoiceCreationFirstStepView.class})
    private String fileName;
    @ManyToMany
    @JoinTable(name = "project_invoice", joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    @JsonBackReference
    private Set<Project> projects = new HashSet<>();

//    @OneToMany
//    private Set<StatusChange> statusChanges = new HashSet<>();

    public Invoice(String number, Double amount, User user, Boolean paid, String date, String validationStatus, String lifeCycleStatus, String currency, Long hours, Long vat, String payday, Set<Task> tasks, String fileName, Set<Project> projects) {
        this.number = number;
        this.amount = amount;
        this.user = user;
        this.paid = paid;
        this.date = date;
        this.validationStatus = validationStatus;
        this.lifeCycleStatus = lifeCycleStatus;
        this.currency = currency;
        this.hours = hours;
        this.vat = vat;
        this.payday = payday;
        this.tasks = tasks;
        this.fileName = fileName;
        this.projects = projects;
    }

    public Invoice() {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(String validationStatus) {
        this.validationStatus = validationStatus;
    }

    public String getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    public void setLifeCycleStatus(String lifeCycleStatus) {
        this.lifeCycleStatus = lifeCycleStatus;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    public Long getVat() {
        return vat;
    }

    public void setVat(Long vat) {
        this.vat = vat;
    }

    public String getPayday() {
        return payday;
    }

    public void setPayday(String payday) {
        this.payday = payday;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Invoice{" +
            "id=" + id +
            ", number='" + number + '\'' +
            ", amount=" + amount +
            ", user=" + user +
            ", paid=" + paid +
            ", date='" + date + '\'' +
            ", validationStatus='" + validationStatus + '\'' +
            ", lifeCycleStatus='" + lifeCycleStatus + '\'' +
            ", currency='" + currency + '\'' +
            ", hours=" + hours +
            ", vat=" + vat +
            ", payday='" + payday + '\'' +
            ", tasks=" + tasks +
            ", fileName='" + fileName + '\'' +
            ", projects=" + projects +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) &&
            Objects.equals(number, invoice.number) &&
            Objects.equals(amount, invoice.amount) &&
            Objects.equals(paid, invoice.paid) &&
            Objects.equals(date, invoice.date) &&
            Objects.equals(validationStatus, invoice.validationStatus) &&
            Objects.equals(lifeCycleStatus, invoice.lifeCycleStatus) &&
            Objects.equals(currency, invoice.currency) &&
            Objects.equals(hours, invoice.hours) &&
            Objects.equals(vat, invoice.vat) &&
            Objects.equals(payday, invoice.payday) &&
            Objects.equals(fileName, invoice.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, amount, paid, date, validationStatus, lifeCycleStatus, currency, hours, vat, payday, fileName);
    }
}
