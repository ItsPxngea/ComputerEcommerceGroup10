package za.ac.cput.repository.impl;
/*
    Author: Ethan Botes
    This is the Supplier Order Repository
    Date: 02 - 04 - 2022
 */

import java.util.HashSet;
import java.util.Set;

public class SupplierOrderRepositoryImpl implements za.ac.cput.repository.SupplierOrderRepository {

    private Set<za.ac.cput.domain.SupplierOrder> supplierOrderDB = null;
    private static SupplierOrderRepositoryImpl repository = null;
    private SupplierOrderRepositoryImpl(){
        supplierOrderDB = new HashSet<za.ac.cput.domain.SupplierOrder>();
    }

    public static SupplierOrderRepositoryImpl getRepository(){
        if(repository == null){
            repository = new SupplierOrderRepositoryImpl();
        }
        return repository;
    }

    public za.ac.cput.domain.SupplierOrder create(za.ac.cput.domain.SupplierOrder supplierOrder){
        boolean success = supplierOrderDB.add(supplierOrder);
        if(!success){
            return null;
        }
        return supplierOrder;
    }

    public za.ac.cput.domain.SupplierOrder read(String orderID) {
        za.ac.cput.domain.SupplierOrder so = supplierOrderDB.stream()
                .filter(e -> e.getOrderID().equals(orderID))
                .findAny()
                .orElse(null);
        return so;
    }


    public za.ac.cput.domain.SupplierOrder update(za.ac.cput.domain.SupplierOrder supplierOrder){
        za.ac.cput.domain.SupplierOrder oldSupplierOrder = read(supplierOrder.getOrderID());
        if (oldSupplierOrder != null){
            supplierOrderDB.remove(oldSupplierOrder);
            supplierOrderDB.add(supplierOrder);
            return supplierOrder;
        }
        return null;
    }

    public boolean delete(String orderID) {
        za.ac.cput.domain.SupplierOrder supplierOrderToDelete = read(orderID);
        if (supplierOrderToDelete == null)
            return false;

        supplierOrderDB.remove(supplierOrderToDelete);
        return true;
    }
        @Override
        public Set<za.ac.cput.domain.SupplierOrder> getAll(){
            return supplierOrderDB;
    }


}
