package za.ac.cput.interfaces;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.Enquiry;
import za.ac.cput.domain.StoreDetails;

import java.util.HashSet;
import java.util.Set;

public class StoreDetailsRepository implements iStoryDetailsRepository{
    private Set<StoreDetails> storeDetailsDB = null;
    private static StoreDetailsRepository repository = null;
    private StoreDetailsRepository(){
        storeDetailsDB = new HashSet<StoreDetails>();
    }

    public static StoreDetailsRepository getRepository(){
        if (repository == null)
            repository = new StoreDetailsRepository();
        return repository;
    }

    public StoreDetails create(StoreDetails storeDetails){
        boolean success = storeDetailsDB.add(storeDetails);
        if (!success)
            return null;
        return storeDetails;
    }

    public StoreDetails read(String storeID){
        StoreDetails sd = storeDetailsDB.stream()
                .filter(e -> e.getStoreID().equals(storeID))
                .findAny()
                .orElse(null);
        return sd;
    }

    public StoreDetails update(StoreDetails storeDetails){
        StoreDetails oldSD = read(storeDetails.getStoreID());
        if (oldSD != null){
            storeDetailsDB.remove(oldSD);
            storeDetailsDB.add(storeDetails);
            return storeDetails;
        }
        return null;
    }

    public boolean delete(String storeID){
        StoreDetails storeDetailsToDelete = read(storeID);
        if (storeDetailsToDelete == null)
            return false;

        storeDetailsDB.remove(storeDetailsToDelete);
        return true;
    }
    @Override
    public Set<StoreDetails> getAll(){
        return storeDetailsDB;
    }
}
