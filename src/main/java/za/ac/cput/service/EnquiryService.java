package za.ac.cput.service;

import za.ac.cput.domain.Enquiry;

import java.util.Set;

public interface EnquiryService extends IService<Enquiry, String>{
    Set<Enquiry> getAll();
}
