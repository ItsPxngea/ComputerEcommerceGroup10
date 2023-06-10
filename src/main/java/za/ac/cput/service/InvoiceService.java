package za.ac.cput.service;

import za.ac.cput.domain.Invoice;

import java.util.Set;

public interface InvoiceService extends IService <Invoice, String>{
    Set<Invoice> getAll();
}
