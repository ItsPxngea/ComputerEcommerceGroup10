package za.ac.cput.repository;
/*
    Author: Alexander Draai
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.Invoice;
import java.util.Set;

public interface iInvoiceRepository {
    public Set<Invoice> getAll();
}
