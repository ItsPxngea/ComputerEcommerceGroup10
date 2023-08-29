package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.service.InvoiceService;

import java.util.List;

/*
    InvoiceServiceImpl.java
    Author: Alexander Draai - 220118744
    This is the implementation for the service Invoice.java
    Date: 10 - 06 - 2023
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;
    @Autowired
    public InvoiceServiceImpl (InvoiceRepository repository) {
       this.repository = repository;
    }

    @Override
    public Invoice create(Invoice invoice) {
        return this.repository.save(invoice);
    }

    @Override
    public Invoice read(String invoiceNumber) {
        return this.repository.findById(invoiceNumber).orElse(null);
    }

    @Override
    public Invoice update(Invoice invoice) {
       if(this.repository.existsById(invoice.getInvoiceNumber()))
           return this.repository.save(invoice);
       return null;
    }

    @Override
    public boolean delete(String invoiceNumber) {
        if(this.repository.existsById(invoiceNumber)){
            this.repository.deleteById(invoiceNumber);
            return true;
        }
        return false;
    }

    @Override
    public List<Invoice> getAll() {
        return repository.findAll();
    }
}
