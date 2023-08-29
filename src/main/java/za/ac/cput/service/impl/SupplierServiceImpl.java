package za.ac.cput.service.impl;

import za.ac.cput.repository.impl.SupplierRepositoryImpl;
import za.ac.cput.service.SupplierService;

import java.util.Set;
/*
Author: Ethan Botes - 220101299
This is the implementation for the service SupplierService
Date 11/06/2023
 */
public class SupplierServiceImpl implements SupplierService {

    private static SupplierServiceImpl service = null;

    private SupplierRepositoryImpl repository = null;


    private SupplierServiceImpl(){
        if(repository == null){
            repository = SupplierRepositoryImpl.getRepository();
        }
    }

    public static SupplierServiceImpl getService(){
        if(service == null){
            service = new SupplierServiceImpl();
        }
        return service;
    }

    @Override
    public za.ac.cput.domain.Supplier create(za.ac.cput.domain.Supplier supplier){return repository.create(supplier);}

    @Override
    public za.ac.cput.domain.Supplier read(String id){
        return repository.read(id);
    }

    @Override
    public za.ac.cput.domain.Supplier update(za.ac.cput.domain.Supplier supplier){
        return repository.update(supplier);
    }

    @Override
    public boolean delete(String id){
        return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.Supplier> getAll(){
        return repository.getAll();
    }

}
