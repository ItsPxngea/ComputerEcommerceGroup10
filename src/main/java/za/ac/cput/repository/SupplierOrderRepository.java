package za.ac.cput.repository;
/*
    Author: Ethan Botes
    This is Supplier Order Repository
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.SupplierOrder;

import java.util.Set;

public interface SupplierOrderRepository {

    public Set<SupplierOrder> getAll();

}
