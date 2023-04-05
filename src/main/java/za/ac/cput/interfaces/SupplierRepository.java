package za.ac.cput.interfaces;

import za.ac.cput.domain.Supplier;


import java.util.HashSet;
import java.util.Set;

public class SupplierRepository implements iSupplierRepository {

    private Set<Supplier> supplierDB = null;
    private static SupplierRepository repository = null;
    private SupplierRepository(){
        supplierDB = new HashSet<Supplier>();
    }

    public static SupplierRepository getRepository(){
        if(repository == null){
            repository = new SupplierRepository();
        }
        return repository;
    }

    public Supplier create(Supplier supplier){
        boolean success = supplierDB.add(supplier);
        if(!success){
            return null;
        }
        return supplier;
    }

    public Supplier read(String supplierID) {
        Supplier s = supplierDB.stream()
                .filter(e -> e.getSupplierID().equals(supplierID))
                .findAny()
                .orElse(null);
        return s;
    }


    public Supplier update(Supplier supplier){
        Supplier oldSupplier = read(supplier.getSupplierID());
        if (oldSupplier != null){
            supplierDB.remove(oldSupplier);
            supplierDB.add(supplier);
            return supplier;
        }
        return null;
    }

    public boolean delete(String supplierID) {
        Supplier supplierToDelete = read(supplierID);
        if (supplierToDelete == null)
            return false;

        supplierDB.remove(supplierToDelete);
        return true;
    }
    @Override
    public Set<Supplier> getAll(){
        return supplierDB;
    }

}
