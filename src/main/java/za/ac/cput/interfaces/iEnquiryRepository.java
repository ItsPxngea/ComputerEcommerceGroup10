package za.ac.cput.interfaces;
import za.ac.cput.domain.Enquiry;

import java.util.Set;
public interface iEnquiryRepository {
    public Set<Enquiry> getAll();
}
