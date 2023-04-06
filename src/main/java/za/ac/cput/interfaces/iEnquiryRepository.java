package za.ac.cput.interfaces;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.Enquiry;

import java.util.Set;
public interface iEnquiryRepository {
    public Set<Enquiry> getAll();
}
