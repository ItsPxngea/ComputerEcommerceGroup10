package za.ac.cput.service.impl;

import za.ac.cput.repository.impl.SupplierOrderRepositoryImpl;
import za.ac.cput.service.SupplierOrderService;

import java.util.Set;

/*
Author: Ethan Botes - 220101299
This is the implementation for the service SupplierOrderService
Date 11/06/2023
 */
public class SupplierOrderServiceImpl implements SupplierOrderService {

    private static SupplierOrderServiceImpl service = null;
    private SupplierOrderRepositoryImpl repository = null;
    private SupplierOrderServiceImpl(){
        if(repository == null){
            repository = SupplierOrderRepositoryImpl.getRepository();
        }
    }


    public static SupplierOrderServiceImpl getService(){
        if(service == null){
            service = new SupplierOrderServiceImpl();
        }
        return service;
    }

    @Override
    public za.ac.cput.domain.SupplierOrder create(za.ac.cput.domain.SupplierOrder supplierOrder){
        return repository.create(supplierOrder);
    }

    @Override
    public za.ac.cput.domain.SupplierOrder read(String id){
        return repository.read(id);
    }

    @Override
    public za.ac.cput.domain.SupplierOrder update(za.ac.cput.domain.SupplierOrder supplierOrder){
        return repository.update(supplierOrder);
    }

    @Override
    public boolean delete(String id){
        return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.SupplierOrder> getAll(){
        return repository.getAll();
    }
}
