package za.ac.cput.service;

/*
Ethan Botes - 220101299
This is the SupplierService interface
Date: 11 - 060 2023
 */

import za.ac.cput.domain.Supplier;

import java.util.Set;

public interface SupplierService extends IService<Supplier, String>{

    Set<Supplier> getAll();


}
