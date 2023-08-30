package za.ac.cput.service;

/*
Ethan Botes - 220101299
This is the SupplierOrderService Interface
Date: 11 - 060 2023
 */

import za.ac.cput.domain.SupplierOrder;

import java.util.List;
import java.util.Set;

public interface SupplierOrderService extends IService<SupplierOrder, String>{

    List<SupplierOrder> getAll();


}
