package za.ac.cput.interfaces;
import za.ac.cput.domain.Enquiry;

import java.util.*;
public class EnquiryRepository implements iEnquiryRepository {
    private Set<Enquiry> enquiryDB = null;
    private static EnquiryRepository repository = null;
    private EnquiryRepository(){
        enquiryDB = new HashSet<Enquiry>();
    }

    public static EnquiryRepository getRepository(){
        if (repository == null)
            repository = new EnquiryRepository();
        return repository;
    }

    public Enquiry create(Enquiry enquiry){
        boolean success = enquiryDB.add(enquiry);
        if (!success)
            return null;
        return enquiry;
    }

    public Enquiry read(String enquiryID){
        Enquiry en = enquiryDB.stream()
                .filter(e -> e.getEnquiryID().equals(enquiryID))
                .findAny()
                .orElse(null);
        return en;
    }

    public Enquiry update(Enquiry enquiry){
        Enquiry oldEnquiry = read(enquiry.getEnquiryID());
        if (oldEnquiry != null){
            enquiryDB.remove(oldEnquiry);
            enquiryDB.add(enquiry);
            return enquiry;
        }
        return null;
    }

    public boolean delete(String enquiryID){
        Enquiry enquiryToDelete = read(enquiryID);
        if (enquiryToDelete == null)
            return false;

        enquiryDB.remove(enquiryToDelete);
        return true;
    }
    @Override
    public Set<Enquiry> getAll(){
        return enquiryDB;
    }
}
