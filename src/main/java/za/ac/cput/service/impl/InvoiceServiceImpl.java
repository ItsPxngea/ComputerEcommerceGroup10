package za.ac.cput.service.impl;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.service.InvoiceService;

import java.util.Set;

public class InvoiceServiceImpl implements InvoiceService {

    private static InvoiceServiceImpl service ;
    private static InvoiceRepository repository;

    public InvoiceServiceImpl (){
        if (repository == null){
            repository = InvoiceRepository.getRepository();
        }
    }

    public static InvoiceServiceImpl getService(){
        if(service == null){
            service = new InvoiceServiceImpl();
        }
        return service;
    }

    @Override
    public Invoice create(Invoice invoice) {
            Invoice readInvoice = repository.create(invoice);
            return readInvoice;
        }

    @Override
    public Invoice read(Invoice invoice) {
        Invoice read = repository.read(invoice.getInvoiceNumber());
        return read;
    }

    @Override
    public Invoice update(Invoice invoice) {
        Invoice InvoiceUpdated = repository.update(invoice);
        return invoice;
    }

    @Override
    public boolean delete(Invoice invoice) {
        Boolean success = repository.delete(invoice.getInvoiceNumber());
        return success;
    }

    @Override
    public Set<Invoice> getAll() {
        return repository.getAll();
    }
}
