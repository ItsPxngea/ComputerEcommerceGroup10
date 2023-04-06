package za.ac.cput.interfaces;


import za.ac.cput.domain.Invoice;
import java.util.HashSet;
import java.util.Set;

public class InvoiceRepository implements iInvoiceRepository {

    private Set<Invoice> invoiceDB ;
    private static InvoiceRepository repository = null;
    private InvoiceRepository(){invoiceDB = new HashSet<Invoice>();}

    public static InvoiceRepository getRepository(){
        if(repository == null){
            repository = new InvoiceRepository();
        }
        return repository;
    }

    public Invoice create(Invoice invoice){
        boolean success = invoiceDB.add(invoice);
        if(!success){
            return null;
        }
        return invoice;
    }

    public Invoice read(String InvoiceNumber){
        Invoice invoice = invoiceDB.stream().filter(e -> e.getInvoiceNumber().equals(InvoiceNumber))
                .findAny()
                .orElse(null);
        return invoice;
    }

    public Invoice update(Invoice invoice) {
        Invoice OldInvoice = read(invoice.getInvoiceNumber());
        if(OldInvoice != null) {
            invoiceDB.remove(OldInvoice);
            invoiceDB.add(invoice);
            return invoice;
        }
        return null;
    }

    public boolean delete(String invoiceNumber){
        Invoice InvoiceToDelete = read(invoiceNumber);
        if (InvoiceToDelete == null){
            return false;
        }
        invoiceDB.remove(InvoiceToDelete);
        return true;
    }

    @Override
    public Set<Invoice> getAll() {return invoiceDB;}

}
