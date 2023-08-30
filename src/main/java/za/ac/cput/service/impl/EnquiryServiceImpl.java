package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.service.EnquiryService;

import java.util.Set;

/*
    EnquiryServiceImpl.java
    Author: Hanno Visser Immelman 221074414
    This is the implementation for the service EnquiryService.java
    Date: 10 - 06 - 2023
 */

@Service
public class EnquiryServiceImpl implements EnquiryService {
    private static EnquiryServiceImpl service;

    @Override
    public Enquiry create(Enquiry enquiry){
        return service.create(enquiry);
    }

    @Override
    public Enquiry read(String id){
        return service.read(id);
    }

    @Override
    public Enquiry update (Enquiry enquiry){
        return service.update(enquiry);
    }

    @Override
    public boolean delete(String id){
        return service.delete(id);
    }

    @Override
    public Set<Enquiry> getAll(){
        return service.getAll();
    }

}
