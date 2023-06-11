package za.ac.cput.service;

import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.InvoiceHistory;

import java.util.Set;
/*
    InvoiceHistoryService.java
    Author: Alexander Draai - 220118744
    This is the Service for InvoiceHistoryService.java
    Date: 10 - 06 - 2023
 */
public interface InvoiceHistoryService extends IService<InvoiceHistory, String>{
    Set<InvoiceHistory> getAll();
}
