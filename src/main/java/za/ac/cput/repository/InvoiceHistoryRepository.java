package za.ac.cput.repository;
/*
    Author: Alexander Draai
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.InvoiceHistory;

import java.util.Set;

public interface InvoiceHistoryRepository {
    public Set<InvoiceHistory> getAll();
}
