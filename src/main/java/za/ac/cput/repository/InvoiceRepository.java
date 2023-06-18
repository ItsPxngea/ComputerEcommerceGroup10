package za.ac.cput.repository;
/*
    Author: Alexander Draai
    Date: 02 - 04 - 2022
 */

import za.ac.cput.domain.Invoice;

import java.util.Set;

public interface InvoiceRepository {
    public Set<Invoice> getAll();
}
