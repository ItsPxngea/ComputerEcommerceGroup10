package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplierOrder;
import za.ac.cput.service.SupplierOrderService;

import java.util.Set;

/*
Author: Ethan Botes - 220101299
This is the implementation for the service SupplierOrderService
Date 11/06/2023
 */

@Service
public class SupplierOrderServiceImpl implements SupplierOrderService {

    @Autowired
    private static SupplierOrderServiceImpl service;

    @Override
    public SupplierOrder create(za.ac.cput.domain.SupplierOrder supplierOrder){
        return service.create(supplierOrder);
    }

    @Override
    public SupplierOrder read(String id){
        return service.read(id);
    }

    @Override
    public SupplierOrder update(za.ac.cput.domain.SupplierOrder supplierOrder){
        return service.update(supplierOrder);
    }

    @Override
    public boolean delete(String id){
        return service.delete(id);
    }

    @Override
    public Set<SupplierOrder> getAll(){
        return service.getAll();
    }
}
