package za.ac.cput.service.impl;

import za.ac.cput.service.EnquiryService;

import java.util.Set;

/*
    EnquiryServiceImpl.java
    Author: Hanno Visser Immelman 221074414
    This is the implementation for the service EnquiryService.java
    Date: 10 - 06 - 2023
 */

public class EnquiryServiceImpl implements EnquiryService {
    private static EnquiryServiceImpl service = null;
    private EnquiryRepositoryImpl repository = null;

    private EnquiryServiceImpl(){
        if (repository == null){
            repository = EnquiryRepositoryImpl.getRepository();
        }
    }

    public static EnquiryServiceImpl getService(){
        if (service == null){
            service = new EnquiryServiceImpl();
        }
        return service;
    }

    @Override
    public za.ac.cput.domain.Enquiry create(za.ac.cput.domain.Enquiry enquiry){
        return repository.create(enquiry);
    }

    @Override
    public za.ac.cput.domain.Enquiry read(String id){
        return repository.read(id);
    }

    @Override
    public za.ac.cput.domain.Enquiry update (za.ac.cput.domain.Enquiry enquiry){
        return repository.update(enquiry);
    }

    @Override
    public boolean delete(String id){
        return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.Enquiry> getAll(){
        return repository.getAll();
    }

}
