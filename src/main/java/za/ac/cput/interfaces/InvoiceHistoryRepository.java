package za.ac.cput.interfaces;

import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.InvoiceHistory;

import java.util.HashSet;
import java.util.Set;

public class InvoiceHistoryRepository implements iInvoiceHistoryRepository {

    private Set<InvoiceHistory> invoiceHistoryDB ;
    private static InvoiceHistoryRepository repository = null;
    private InvoiceHistoryRepository() {invoiceHistoryDB = new HashSet<InvoiceHistory>();}


    public static InvoiceHistoryRepository getRepository(){
        if(repository == null){
            repository = new InvoiceHistoryRepository();
        }
        return repository;
    }

public InvoiceHistory create(InvoiceHistory invoiceHistory){
    boolean success = invoiceHistoryDB.add(invoiceHistory);
    if(!success){
        return null;
    }
    return invoiceHistory;
}

    public InvoiceHistory read(String InvoiceNumber){
        InvoiceHistory invoiceHistory = invoiceHistoryDB.stream()
                .filter(e -> e.getInvoiceNumber().equals(InvoiceNumber))
                .findAny()
                .orElse(null);
        return invoiceHistory;
    }

    public InvoiceHistory update(InvoiceHistory invoiceHistory){
        InvoiceHistory OldInvoiceHistory = read(invoiceHistory.getInvoiceNumber());
        if(OldInvoiceHistory != null){
            invoiceHistoryDB.remove(OldInvoiceHistory);
            invoiceHistoryDB.add(invoiceHistory);
            return invoiceHistory;
        }
        return null ;
    }

    public boolean delete(String invoiceNumber){
        InvoiceHistory invoiceToDelete = read(invoiceNumber);
        if(invoiceToDelete == null){
            return false;
        }
        invoiceHistoryDB.remove(invoiceToDelete);
        return true;
    }

    @Override
    public Set<InvoiceHistory> getAll() {
        return null;
    }
}
