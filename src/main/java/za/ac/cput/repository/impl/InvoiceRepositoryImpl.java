package za.ac.cput.repository.impl;
/*
    Author: Alexander Draai
    This is Invoice Repository
    Date: 02 - 04 - 2022
 */

import java.util.HashSet;
import java.util.Set;

public class InvoiceRepositoryImpl implements za.ac.cput.repository.InvoiceRepository {

    private Set<za.ac.cput.domain.Invoice> invoiceDB ;
    private static InvoiceRepositoryImpl repository = null;
    private InvoiceRepositoryImpl(){invoiceDB = new HashSet<za.ac.cput.domain.Invoice>();}

    public static InvoiceRepositoryImpl getRepository(){
        if(repository == null){
            repository = new InvoiceRepositoryImpl();
        }
        return repository;
    }

    public za.ac.cput.domain.Invoice create(za.ac.cput.domain.Invoice invoice){
        boolean success = invoiceDB.add(invoice);
        if(!success){
            return null;
        }
        return invoice;
    }

    public za.ac.cput.domain.Invoice read(String InvoiceNumber){
        za.ac.cput.domain.Invoice invoice = invoiceDB.stream().filter(e -> e.getInvoiceNumber().equals(InvoiceNumber))
                .findAny()
                .orElse(null);
        return invoice;
    }

    public za.ac.cput.domain.Invoice update(za.ac.cput.domain.Invoice invoice) {
        za.ac.cput.domain.Invoice oldInvoice = read(invoice.getInvoiceNumber());
        if(oldInvoice != null) {
            invoiceDB.remove(oldInvoice);
            invoiceDB.add(invoice);
            return invoice;
        }
        return null;
    }

    public boolean delete(String invoiceNumber){
        za.ac.cput.domain.Invoice InvoiceToDelete = read(invoiceNumber);
        if (InvoiceToDelete == null){
            return false;
        }
        invoiceDB.remove(InvoiceToDelete);
        return true;
    }

    @Override
    public Set<za.ac.cput.domain.Invoice> getAll() {return invoiceDB;}

}
