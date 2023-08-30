package za.ac.cput.repository;
/*
    Author: Alexander Draai
    Date: 02 - 04 - 2022
 */

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Invoice;

import java.util.Set;

@Repository
public interface InvoiceRepository {
    public Set<Invoice> getAll();
}
