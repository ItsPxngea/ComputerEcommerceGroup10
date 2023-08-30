package za.ac.cput.service.impl;

import za.ac.cput.domain.Invoice;
import za.ac.cput.service.InvoiceService;

import java.util.Set;

/*
    InvoiceServiceImpl.java
    Author: Alexander Draai - 220118744
    This is the implementation for the service InvoiceHistoryServiceImpl.java
    Date: 10 - 06 - 2023
 */

public class InvoiceServiceImpl implements InvoiceService {

    private static InvoiceServiceImpl service ;

    @Override
    public za.ac.cput.domain.Invoice create(Invoice invoice) {
            za.ac.cput.domain.Invoice readInvoice = service.create(invoice);
            return readInvoice;
        }

    @Override
    public za.ac.cput.domain.Invoice read(String id) {
        za.ac.cput.domain.Invoice read = service.read(id);
        return read;
    }

    @Override
    public za.ac.cput.domain.Invoice update(Invoice invoice) {
        za.ac.cput.domain.Invoice InvoiceUpdated = service.update(invoice);
        return invoice;
    }

    @Override
    public boolean delete(String id) {
        Boolean success = service.delete(id);
        return success;
    }

    @Override
    public Set<Invoice> getAll() {
        return service.getAll();
    }
}
