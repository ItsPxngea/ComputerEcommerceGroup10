package za.ac.cput.interfaces;

import za.ac.cput.domain.SupplierOrder;

import java.util.Set;

public interface iSupplierOrderRepository {

    public Set<SupplierOrder> getAll();

}
