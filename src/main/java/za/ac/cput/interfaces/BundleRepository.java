package za.ac.cput.interfaces;
/*
    Author: Reece Bergstedt
    This is BundleRepository Repository
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.Bundle;
import java.util.*;
public class BundleRepository implements iBundleRepository {

    private Set<Bundle> bundleDB = null;
    private static BundleRepository repository = null;
    private BundleRepository(){
        bundleDB = new HashSet<Bundle>();
    }

    public static BundleRepository getRepository(){
        if(repository == null){
            repository = new BundleRepository();
        }
        return repository;
    }

    public Bundle create(Bundle bundle) {
        boolean success = bundleDB.add(bundle);
        if(!success) {
            return null;
        }
        return bundle;
    }

    public Bundle read(String bundleID) {
        Bundle b = bundleDB.stream()
                .filter(e -> e.getBundleID().equals(bundleID))
                .findAny()
                .orElse(null);
        return b;
    }

    public Bundle update(Bundle bundle) {
        Bundle oldBundle = read(bundle.getBundleID());
        if(oldBundle != null){
            bundleDB.remove(oldBundle);
            bundleDB.add(bundle);
            return bundle;
        }
        return null;
    }

    public boolean delete(String bundleID) {
        Bundle bundleToDelete = read(bundleID);
        if(bundleToDelete == null){
            return false;
        }
        bundleDB.remove(bundleToDelete);
        return true;
    }

    @Override
    public Set<Bundle> getAll() {
        return bundleDB;
    }
}
