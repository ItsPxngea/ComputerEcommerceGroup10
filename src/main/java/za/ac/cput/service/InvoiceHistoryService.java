package za.ac.cput.service;

import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.InvoiceHistory;

import java.util.Set;

public interface InvoiceHistoryService extends IService<InvoiceHistory, String>{
    Set<InvoiceHistory> getAll();
}
