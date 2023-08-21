package za.ac.cput.repository.impl;
/*
    Author: Alexander Draai
    This is Invoice History Repository
    Date: 02 - 04 - 2022
 */
import za.ac.cput.repository.InvoiceHistoryRepository;

import java.util.HashSet;
import java.util.Set;

public class InvoiceHistoryImpl implements InvoiceHistoryRepository {

    private Set<za.ac.cput.domain.InvoiceHistory> invoiceHistoryDB ;
    private static InvoiceHistoryImpl repository = null;
    private InvoiceHistoryImpl() {invoiceHistoryDB = new HashSet<za.ac.cput.domain.InvoiceHistory>();}


    public static InvoiceHistoryImpl getRepository(){
        if(repository == null){
            repository = new InvoiceHistoryImpl();
        }
        return repository;
    }

public za.ac.cput.domain.InvoiceHistory create(za.ac.cput.domain.InvoiceHistory invoiceHistory){
    boolean success = invoiceHistoryDB.add(invoiceHistory);
    if(!success){
        return null;
    }
    return invoiceHistory;
}

    public za.ac.cput.domain.InvoiceHistory read(String historyID){
        za.ac.cput.domain.InvoiceHistory invoiceHistory = invoiceHistoryDB.stream()
                .filter(e -> e.getHistoryID().equals(historyID))
                .findAny()
                .orElse(null);
        return invoiceHistory;
    }

    public za.ac.cput.domain.InvoiceHistory update(za.ac.cput.domain.InvoiceHistory invoiceHistory){
        za.ac.cput.domain.InvoiceHistory oldInvoiceHistory = read(invoiceHistory.getHistoryID());
        if(oldInvoiceHistory != null){
            invoiceHistoryDB.remove(oldInvoiceHistory);
            invoiceHistoryDB.add(invoiceHistory);
            return invoiceHistory;
        }
        return null ;
    }

    public boolean delete(String historyID){
        za.ac.cput.domain.InvoiceHistory invoiceToDelete = read(historyID);
        if(invoiceToDelete == null){
            return false;
        }
        invoiceHistoryDB.remove(invoiceToDelete);
        return true;
    }

    @Override
    public Set<za.ac.cput.domain.InvoiceHistory> getAll() {
        return null;
    }
}
