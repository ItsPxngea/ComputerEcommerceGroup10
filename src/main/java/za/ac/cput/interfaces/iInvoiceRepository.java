package za.ac.cput.interfaces;

import za.ac.cput.domain.Invoice;

import java.util.Set;

public interface iInvoiceRepository {
    public Set<Invoice> getAll();
}
