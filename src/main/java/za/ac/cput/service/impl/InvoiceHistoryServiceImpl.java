package za.ac.cput.service.impl;

import za.ac.cput.repository.impl.InvoiceHistoryImpl;
import za.ac.cput.service.InvoiceHistoryService;

import java.util.Set;
/*
    InvoiceHistoryServiceImpl.java
    Author: Alexander Draai - 220118744
    This is the implementation for the service InvoiceHistoryServiceImpl.java
    Date: 10 - 06 - 2023
 */
public class InvoiceHistoryServiceImpl implements InvoiceHistoryService {

    private static InvoiceHistoryService serivce ;
    private static InvoiceHistoryImpl repository ;


    private InvoiceHistoryServiceImpl(){
        if(repository == null){
            repository = InvoiceHistoryImpl.getRepository();
        }
    }

    public static InvoiceHistoryService getService(){
        if(serivce == null){
            serivce = new InvoiceHistoryServiceImpl();
        }
        return serivce;
    }


    @Override
    public za.ac.cput.domain.InvoiceHistory create(za.ac.cput.domain.InvoiceHistory invoiceHistory) {
        za.ac.cput.domain.InvoiceHistory readhistory = repository.create(invoiceHistory);
        return readhistory;
    }

    @Override
    public za.ac.cput.domain.InvoiceHistory read(String id) {
        za.ac.cput.domain.InvoiceHistory read = repository.read(id);
        return read;
    }

    @Override
    public za.ac.cput.domain.InvoiceHistory update(za.ac.cput.domain.InvoiceHistory invoiceHistory) {
        za.ac.cput.domain.InvoiceHistory updatedHistory = repository.update(invoiceHistory);
        return updatedHistory;

    }

    @Override
    public boolean delete(String id) {
       return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.InvoiceHistory> getAll() {
        return repository.getAll();
    }
}
