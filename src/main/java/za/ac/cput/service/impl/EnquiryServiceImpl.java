package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.repository.EnquiryRepository;
import za.ac.cput.service.EnquiryService;

import java.util.List;
import java.util.Set;

/*
    EnquiryServiceImpl.java
    Author: Hanno Visser Immelman 221074414
    This is the implementation for the service EnquiryService.java
    Date: 10 - 06 - 2023
 */

@Service
public class EnquiryServiceImpl implements EnquiryService {
    private EnquiryRepository repository;

    @Autowired
    private EnquiryServiceImpl(EnquiryRepository repository){
        this.repository = repository;
    }

    @Override
    public Enquiry create(Enquiry enquiry) {
        return this.repository.save(enquiry);
    }

    @Override
    public Enquiry read(String customerID) {
        return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public Enquiry update(Enquiry enquiry) {
        if(this.repository.existsById((enquiry.getEnquiryID())))
            return this.repository.save(enquiry);
        return null;
    }

    @Override
    public boolean delete(String enquiryID) {
        if (this.repository.existsById(enquiryID)){
            this.repository.deleteById(enquiryID);
            return  true;
        }
        return false;
    }

    @Override
    public List<Enquiry> getAll() {
        return this.repository.findAll();
    }

}
