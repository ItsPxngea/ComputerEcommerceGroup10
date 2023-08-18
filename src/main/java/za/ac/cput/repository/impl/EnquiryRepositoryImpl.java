package za.ac.cput.repository.impl;
/*
    Author: Hanno Visser Immelman 221074414
    This is Enquiry Repository
    Date: 02 - 04 - 2022
 */

import za.ac.cput.repository.EnquiryRepository;

import java.util.HashSet;
import java.util.Set;

public class EnquiryRepositoryImpl implements EnquiryRepository {
    private Set<za.ac.cput.domain.Enquiry> enquiryDB = null;
    private static EnquiryRepositoryImpl repository = null;
    private EnquiryRepositoryImpl(){
        enquiryDB = new HashSet<za.ac.cput.domain.Enquiry>();
    }

    public static EnquiryRepositoryImpl getRepository(){
        if (repository == null)
            repository = new EnquiryRepositoryImpl();
        return repository;
    }

    public za.ac.cput.domain.Enquiry create(za.ac.cput.domain.Enquiry enquiry){
        boolean success = enquiryDB.add(enquiry);
        if (!success)
            return null;
        return enquiry;
    }

    public za.ac.cput.domain.Enquiry read(String enquiryID){
        za.ac.cput.domain.Enquiry en = enquiryDB.stream()
                .filter(e -> e.getEnquiryID().equals(enquiryID))
                .findAny()
                .orElse(null);
        return en;
    }

    public za.ac.cput.domain.Enquiry update(za.ac.cput.domain.Enquiry enquiry){
        za.ac.cput.domain.Enquiry oldEnquiry = read(enquiry.getEnquiryID());
        if (oldEnquiry != null){
            enquiryDB.remove(oldEnquiry);
            enquiryDB.add(enquiry);
            return enquiry;
        }
        return null;
    }

    public boolean delete(String enquiryID){
        za.ac.cput.domain.Enquiry enquiryToDelete = read(enquiryID);
        if (enquiryToDelete == null)
            return false;

        enquiryDB.remove(enquiryToDelete);
        return true;
    }
    @Override
    public Set<za.ac.cput.domain.Enquiry> getAll(){
        return enquiryDB;
    }
}
