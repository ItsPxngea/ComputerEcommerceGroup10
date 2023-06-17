package za.ac.cput.service.impl;

import za.ac.cput.repository.impl.InvoiceRepositoryImpl;
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
    private static InvoiceRepositoryImpl repository;

    public InvoiceServiceImpl (){
        if (repository == null){
            repository = InvoiceRepositoryImpl.getRepository();
        }
    }

    public static InvoiceServiceImpl getService(){
        if(service == null){
            service = new InvoiceServiceImpl();
        }
        return service;
    }

    @Override
    public za.ac.cput.domain.Invoice create(za.ac.cput.domain.Invoice invoice) {
            za.ac.cput.domain.Invoice readInvoice = repository.create(invoice);
            return readInvoice;
        }

    @Override
    public za.ac.cput.domain.Invoice read(String id) {
        za.ac.cput.domain.Invoice read = repository.read(id);
        return read;
    }

    @Override
    public za.ac.cput.domain.Invoice update(za.ac.cput.domain.Invoice invoice) {
        za.ac.cput.domain.Invoice InvoiceUpdated = repository.update(invoice);
        return invoice;
    }

    @Override
    public boolean delete(String id) {
        Boolean success = repository.delete(id);
        return success;
    }

    @Override
    public Set<za.ac.cput.domain.Invoice> getAll() {
        return repository.getAll();
    }
}
