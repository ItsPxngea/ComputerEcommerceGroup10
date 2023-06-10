package za.ac.cput.service.impl;

import za.ac.cput.domain.InvoiceHistory;
import za.ac.cput.repository.InvoiceHistoryRepository;
import za.ac.cput.service.InvoiceHistoryService;

import java.util.Set;

public class InvoiceHistoryServiceImpl implements InvoiceHistoryService {

    private static InvoiceHistoryService serivce ;
    private static InvoiceHistoryRepository repository ;


    private InvoiceHistoryServiceImpl(){
        if(repository == null){
            repository = InvoiceHistoryRepository.getRepository();
        }
    }

    public static InvoiceHistoryService getService(){
        if(serivce == null){
            serivce = new InvoiceHistoryServiceImpl();
        }
        return serivce;
    }


    @Override
    public InvoiceHistory create(InvoiceHistory invoiceHistory) {
        InvoiceHistory readhistory = repository.create(invoiceHistory);
        return readhistory;
    }

    @Override
    public InvoiceHistory read(InvoiceHistory invoiceHistory) {
        InvoiceHistory read = repository.read(invoiceHistory.getHistoryID());
        return read;
    }

    @Override
    public InvoiceHistory update(InvoiceHistory invoiceHistory) {
        InvoiceHistory updatedHistory = repository.update(invoiceHistory);
        return updatedHistory;

    }

    @Override
    public boolean delete(InvoiceHistory invoiceHistory) {
       return repository.delete(invoiceHistory.getHistoryID());
    }

    @Override
    public Set<InvoiceHistory> getAll() {
        return repository.getAll();
    }
}
