package za.ac.cput.interfaces;
/*
    Author: Alexander Draai
    This is Invoice History Repository
    Date: 02 - 04 - 2022
 */
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

    public InvoiceHistory read(String historyID){
        InvoiceHistory invoiceHistory = invoiceHistoryDB.stream()
                .filter(e -> e.getHistoryID().equals(historyID))
                .findAny()
                .orElse(null);
        return invoiceHistory;
    }

    public InvoiceHistory update(InvoiceHistory invoiceHistory){
        InvoiceHistory oldInvoiceHistory = read(invoiceHistory.getHistoryID());
        if(oldInvoiceHistory != null){
            invoiceHistoryDB.remove(oldInvoiceHistory);
            invoiceHistoryDB.add(invoiceHistory);
            return invoiceHistory;
        }
        return null ;
    }

    public boolean delete(String historyID){
        InvoiceHistory invoiceToDelete = read(historyID);
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
