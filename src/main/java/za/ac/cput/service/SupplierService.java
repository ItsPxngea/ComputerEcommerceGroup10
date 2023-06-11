package za.ac.cput.service;

import za.ac.cput.domain.Supplier;

import java.util.Set;

public interface SupplierService extends IService<Supplier, String>{

    Set<Supplier> getAll();


}
