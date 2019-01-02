package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.Invoice;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Set;

public interface InvoiceService {

    Set<Invoice> getInvoices();

    void createInvoice(Invoice invoice);

    Invoice findInvoiceById(Long id);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(Long id);

    Invoice insertValuesToInvoice(String invoiceString);

    Invoice attachTasksToInvoice(Long invoiceId, String tasks, Long userId);

    Invoice detachTasksFromInvoice(Long invoiceId, String tasks, Long userId);

    Invoice addInvoice(MultipartFile file, String fileName, Long userId);

    Invoice sendForApproval(Long invoiceId);

    InputStream getInvoiceFile(String fileName);

    String extractBillingDetails(Long invoiceId);
}
