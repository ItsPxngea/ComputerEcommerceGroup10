package za.ac.cput.interfaces;
/*
    Author: Alexander Draai
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.InvoiceHistory;

import java.util.Set;

public interface iInvoiceHistoryRepository {
    public Set<InvoiceHistory> getAll();
}
