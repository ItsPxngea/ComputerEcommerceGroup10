package za.ac.cput.interfaces;

import za.ac.cput.domain.InvoiceHistory;

import java.util.Set;

public interface iInvoiceHistoryRepository {
    public Set<InvoiceHistory> getAll();
}
