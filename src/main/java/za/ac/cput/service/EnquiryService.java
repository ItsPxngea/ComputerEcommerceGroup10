package za.ac.cput.service;

import za.ac.cput.domain.Enquiry;

import java.util.List;
import java.util.Set;

/*
    EnquiryService.java
    Author: Hanno Visser Immelman 221074414
    This is the Service for the service the Enquiry entity
    Date: 10 - 06 - 2023
 */

public interface EnquiryService extends IService<Enquiry, String>{
    List<Enquiry> getAll();
}
