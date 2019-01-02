package io.github.jhipster.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class BillingDetails {

    private Long totalEstimatedHours;
    private Long doneEstimatedHours;
    private Long donePercentage;
    private Long bugEstimatedHours;
    private Long bugPercentage;
    private Long invoiceEstimationDifference;
    private Long hoursReported;

    public BillingDetails(Long totalEstimatedHours, Long doneEstimatedHours, Long donePercentage, Long bugEstimatedHours, Long bugPercentage, Long invoiceEstimationDifference, Long hoursReported) {
        this.totalEstimatedHours = totalEstimatedHours;
        this.doneEstimatedHours = doneEstimatedHours;
        this.donePercentage = donePercentage;
        this.bugEstimatedHours = bugEstimatedHours;
        this.bugPercentage = bugPercentage;
        this.invoiceEstimationDifference = invoiceEstimationDifference;
        this.hoursReported = hoursReported;
    }

    public BillingDetails() {
    }

    public Long getTotalEstimatedHours() {
        return totalEstimatedHours;
    }

    public void setTotalEstimatedHours(Long totalEstimatedHours) {
        this.totalEstimatedHours = totalEstimatedHours;
    }

    public Long getDoneEstimatedHours() {
        return doneEstimatedHours;
    }

    public void setDoneEstimatedHours(Long doneEstimatedHours) {
        this.doneEstimatedHours = doneEstimatedHours;
    }

    public Long getDonePercentage() {
        return donePercentage;
    }

    public void setDonePercentage(Long donePercentage) {
        this.donePercentage = donePercentage;
    }

    public Long getBugEstimatedHours() {
        return bugEstimatedHours;
    }

    public void setBugEstimatedHours(Long bugEstimatedHours) {
        this.bugEstimatedHours = bugEstimatedHours;
    }

    public Long getBugPercentage() {
        return bugPercentage;
    }

    public void setBugPercentage(Long bugPercentage) {
        this.bugPercentage = bugPercentage;
    }

    public Long getInvoiceEstimationDifference() {
        return invoiceEstimationDifference;
    }

    public void setInvoiceEstimationDifference(Long invoiceEstimationDifference) {
        this.invoiceEstimationDifference = invoiceEstimationDifference;
    }

    public Long getHoursReported() {
        return hoursReported;
    }

    public void setHoursReported(Long hoursReported) {
        this.hoursReported = hoursReported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillingDetails that = (BillingDetails) o;
        return Objects.equals(totalEstimatedHours, that.totalEstimatedHours) &&
            Objects.equals(doneEstimatedHours, that.doneEstimatedHours) &&
            Objects.equals(donePercentage, that.donePercentage) &&
            Objects.equals(bugEstimatedHours, that.bugEstimatedHours) &&
            Objects.equals(bugPercentage, that.bugPercentage) &&
            Objects.equals(invoiceEstimationDifference, that.invoiceEstimationDifference) &&
            Objects.equals(hoursReported, that.hoursReported);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalEstimatedHours, doneEstimatedHours, donePercentage, bugEstimatedHours, bugPercentage, invoiceEstimationDifference, hoursReported);
    }

    @Override
    public String toString() {
        return "BillingDetails{" +
            "totalEstimatedHours=" + totalEstimatedHours +
            ", doneEstimatedHours=" + doneEstimatedHours +
            ", donePercentage=" + donePercentage +
            ", bugEstimatedHours=" + bugEstimatedHours +
            ", bugPercentage=" + bugPercentage +
            ", invoiceEstimationDifference=" + invoiceEstimationDifference +
            ", hoursReported=" + hoursReported +
            '}';
    }
}
