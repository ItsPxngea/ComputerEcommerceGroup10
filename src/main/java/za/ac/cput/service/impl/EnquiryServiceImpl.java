package za.ac.cput.service.impl;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.Enquiry;
import za.ac.cput.repository.EnquiryRepository;
import za.ac.cput.service.EnquiryService;

import java.util.Set;

public class EnquiryServiceImpl implements EnquiryService {
    private static EnquiryServiceImpl service = null;
    private EnquiryRepository repository = null;

    private EnquiryServiceImpl(){
        if (repository == null){
            repository = EnquiryRepository.getRepository();
        }
    }

    public static EnquiryServiceImpl getService(){
        if (service == null){
            service = new EnquiryServiceImpl();
        }
        return service;
    }

    @Override
    public Enquiry create(Enquiry enquiry){
        return repository.create(enquiry);
    }

    @Override
    public Enquiry read(Enquiry id){
        return repository.read(id.getCustomerID());
    }

    @Override
    public Enquiry update (Enquiry enquiry){
        return repository.update(enquiry);
    }

    @Override
    public boolean delete(Enquiry id){
        return repository.delete(id.getEnquiryID());
    }

    @Override
    public Set<Enquiry> getAll(){
        return repository.getAll();
    }

}
