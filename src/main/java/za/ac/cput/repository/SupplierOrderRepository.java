package za.ac.cput.repository;
/*
    Author: Ethan Botes
    This is the Supplier Order Repository
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.SupplierOrder;

import java.util.HashSet;
import java.util.Set;

public class SupplierOrderRepository implements iSupplierOrderRepository {

    private Set<SupplierOrder> supplierOrderDB = null;
    private static SupplierOrderRepository repository = null;
    private SupplierOrderRepository(){
        supplierOrderDB = new HashSet<SupplierOrder>();
    }

    public static SupplierOrderRepository getRepository(){
        if(repository == null){
            repository = new SupplierOrderRepository();
        }
        return repository;
    }

    public SupplierOrder create(SupplierOrder supplierOrder){
        boolean success = supplierOrderDB.add(supplierOrder);
        if(!success){
            return null;
        }
        return supplierOrder;
    }

    public SupplierOrder read(String orderID) {
        SupplierOrder so = supplierOrderDB.stream()
                .filter(e -> e.getOrderID().equals(orderID))
                .findAny()
                .orElse(null);
        return so;
    }


    public SupplierOrder update(SupplierOrder supplierOrder){
        SupplierOrder oldSupplierOrder = read(supplierOrder.getOrderID());
        if (oldSupplierOrder != null){
            supplierOrderDB.remove(oldSupplierOrder);
            supplierOrderDB.add(supplierOrder);
            return supplierOrder;
        }
        return null;
    }

    public boolean delete(String orderID) {
        SupplierOrder supplierOrderToDelete = read(orderID);
        if (supplierOrderToDelete == null)
            return false;

        supplierOrderDB.remove(supplierOrderToDelete);
        return true;
    }
        @Override
        public Set<SupplierOrder> getAll(){
            return supplierOrderDB;
    }


}
