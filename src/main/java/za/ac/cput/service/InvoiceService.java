package za.ac.cput.service;

import za.ac.cput.domain.Invoice;

import java.util.Set;
/*
Author: Alexander Draai - 220118744
This is the Service for InvoiceService.java
Date: 10 - 06 - 2023
 */
public interface InvoiceService extends IService <Invoice, String>{
    Set<Invoice> getAll();
}
