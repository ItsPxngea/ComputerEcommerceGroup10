package za.ac.cput.service;

import za.ac.cput.domain.SupplierAddress;

import java.util.List;

public interface SupplierAddressService extends IService<SupplierAddress,String>{
    List<SupplierAddress> getAll();
}
