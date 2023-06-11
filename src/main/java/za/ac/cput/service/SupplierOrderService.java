package za.ac.cput.service;


import za.ac.cput.domain.SupplierOrder;

import java.util.Set;

public interface SupplierOrderService extends IService<SupplierOrder, String>{

    Set<SupplierOrder> getAll();


}
