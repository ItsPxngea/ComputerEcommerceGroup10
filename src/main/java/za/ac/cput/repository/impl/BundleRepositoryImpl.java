package za.ac.cput.repository.impl;
/*
    Author: Reece Bergstedt
    This is BundleRepository Repository
    Date: 02 - 04 - 2022
 */

import java.util.HashSet;
import java.util.Set;
public class BundleRepositoryImpl implements za.ac.cput.repository.BundleRepository {

    private Set<za.ac.cput.domain.Bundle> bundleDB = null;
    private static BundleRepositoryImpl repository = null;
    private BundleRepositoryImpl(){
        bundleDB = new HashSet<za.ac.cput.domain.Bundle>();
    }

    public static BundleRepositoryImpl getRepository(){
        if(repository == null){
            repository = new BundleRepositoryImpl();
        }
        return repository;
    }

    public za.ac.cput.domain.Bundle create(za.ac.cput.domain.Bundle bundle) {
        boolean success = bundleDB.add(bundle);
        if(!success) {
            return null;
        }
        return bundle;
    }

    public za.ac.cput.domain.Bundle read(String bundleID) {
        za.ac.cput.domain.Bundle b = bundleDB.stream()
                .filter(e -> e.getBundleID().equals(bundleID))
                .findAny()
                .orElse(null);
        return b;
    }

    public za.ac.cput.domain.Bundle update(za.ac.cput.domain.Bundle bundle) {
        za.ac.cput.domain.Bundle oldBundle = read(bundle.getBundleID());
        if(oldBundle != null){
            bundleDB.remove(oldBundle);
            bundleDB.add(bundle);
            return bundle;
        }
        return null;
    }

    public boolean delete(String bundleID) {
        za.ac.cput.domain.Bundle bundleToDelete = read(bundleID);
        if(bundleToDelete == null){
            return false;
        }
        bundleDB.remove(bundleToDelete);
        return true;
    }

    @Override
    public Set<za.ac.cput.domain.Bundle> getAll() {
        return bundleDB;
    }
}
