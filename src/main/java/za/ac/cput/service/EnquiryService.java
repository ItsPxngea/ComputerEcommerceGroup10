package za.ac.cput.service;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.Enquiry;

import java.util.Set;

public interface EnquiryService extends IService<Enquiry, String>{
    Set<Enquiry> getAll();
}
