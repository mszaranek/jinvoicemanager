package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
public class StatusChange {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",allocationSize = 1)
    private Long id;
    @ManyToOne
    private Invoice invoice;
    private String statusBefore;
    private String statusAfter;
    private Date date;
    @ManyToOne
    private User creator;
    private String reason;

    public StatusChange() {

    }

    public StatusChange(Invoice invoice, String statusBefore, String statusAfter, Date date, User creator, String reason) {
        this.invoice = invoice;
        this.statusBefore = statusBefore;
        this.statusAfter = statusAfter;
        this.date = date;
        this.creator = creator;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getStatusBefore() {
        return statusBefore;
    }

    public void setStatusBefore(String statusBefore) {
        this.statusBefore = statusBefore;
    }

    public String getStatusAfter() {
        return statusAfter;
    }

    public void setStatusAfter(String statusAfter) {
        this.statusAfter = statusAfter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusChange that = (StatusChange) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(invoice, that.invoice) &&
            Objects.equals(statusBefore, that.statusBefore) &&
            Objects.equals(statusAfter, that.statusAfter) &&
            Objects.equals(date, that.date) &&
            Objects.equals(creator, that.creator) &&
            Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoice, statusBefore, statusAfter, date, creator, reason);
    }
}
