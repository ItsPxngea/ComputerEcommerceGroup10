package za.ac.cput.repository;
/*
    Author: Hanno Visser Immelman 221074414
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.Enquiry;

import java.util.Set;
public interface iEnquiryRepository {
    public Set<Enquiry> getAll();
}
