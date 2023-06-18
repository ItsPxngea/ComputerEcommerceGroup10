package za.ac.cput.repository.impl;
/*
    Author: Hanno Visser Immelman
    This is Store Details Repository
    Date: 02 - 04 - 2022
 */
import za.ac.cput.repository.StoryDetailsRepository;

import java.util.HashSet;
import java.util.Set;

public class StoreDetailsRepositoryImpl implements StoryDetailsRepository {
    private Set<za.ac.cput.domain.StoreDetails> storeDetailsDB = null;
    private static StoreDetailsRepositoryImpl repository = null;
    private StoreDetailsRepositoryImpl(){
        storeDetailsDB = new HashSet<za.ac.cput.domain.StoreDetails>();
    }

    public static StoreDetailsRepositoryImpl getRepository(){
        if (repository == null)
            repository = new StoreDetailsRepositoryImpl();
        return repository;
    }

    public za.ac.cput.domain.StoreDetails create(za.ac.cput.domain.StoreDetails storeDetails){
        boolean success = storeDetailsDB.add(storeDetails);
        if (!success)
            return null;
        return storeDetails;
    }

    public za.ac.cput.domain.StoreDetails read(String storeID){
        za.ac.cput.domain.StoreDetails sd = storeDetailsDB.stream()
                .filter(e -> e.getStoreID().equals(storeID))
                .findAny()
                .orElse(null);
        return sd;
    }

    public za.ac.cput.domain.StoreDetails update(za.ac.cput.domain.StoreDetails storeDetails){
        za.ac.cput.domain.StoreDetails oldSD = read(storeDetails.getStoreID());
        if (oldSD != null){
            storeDetailsDB.remove(oldSD);
            storeDetailsDB.add(storeDetails);
            return storeDetails;
        }
        return null;
    }

    public boolean delete(String storeID){
        za.ac.cput.domain.StoreDetails storeDetailsToDelete = read(storeID);
        if (storeDetailsToDelete == null)
            return false;

        storeDetailsDB.remove(storeDetailsToDelete);
        return true;
    }
    @Override
    public Set<za.ac.cput.domain.StoreDetails> getAll(){
        return storeDetailsDB;
    }
}
