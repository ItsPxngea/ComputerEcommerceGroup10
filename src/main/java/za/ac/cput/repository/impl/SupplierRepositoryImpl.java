package za.ac.cput.repository.impl;
/*
    Author: Ethan Botes
    This is the Supplier Repository
    Date: 02 - 04 - 2022
 */

import java.util.HashSet;
import java.util.Set;

public class SupplierRepositoryImpl implements za.ac.cput.repository.SupplierRepository {

    private Set<za.ac.cput.domain.Supplier> supplierDB = null;
    private static SupplierRepositoryImpl repository = null;
    private SupplierRepositoryImpl(){
        supplierDB = new HashSet<za.ac.cput.domain.Supplier>();
    }

    public static SupplierRepositoryImpl getRepository(){
        if(repository == null){
            repository = new SupplierRepositoryImpl();
        }
        return repository;
    }

    public za.ac.cput.domain.Supplier create(za.ac.cput.domain.Supplier supplier){
        boolean success = supplierDB.add(supplier);
        if(!success){
            return null;
        }
        return supplier;
    }

    public za.ac.cput.domain.Supplier read(String supplierID) {
        za.ac.cput.domain.Supplier s = supplierDB.stream()
                .filter(e -> e.getSupplierID().equals(supplierID))
                .findAny()
                .orElse(null);
        return s;
    }


    public za.ac.cput.domain.Supplier update(za.ac.cput.domain.Supplier supplier){
        za.ac.cput.domain.Supplier oldSupplier = read(supplier.getSupplierID());
        if (oldSupplier != null){
            supplierDB.remove(oldSupplier);
            supplierDB.add(supplier);
            return supplier;
        }
        return null;
    }

    public boolean delete(String supplierID) {
        za.ac.cput.domain.Supplier supplierToDelete = read(supplierID);
        if (supplierToDelete == null)
            return false;

        supplierDB.remove(supplierToDelete);
        return true;
    }
    @Override
    public Set<za.ac.cput.domain.Supplier> getAll(){
        return supplierDB;
    }

}
