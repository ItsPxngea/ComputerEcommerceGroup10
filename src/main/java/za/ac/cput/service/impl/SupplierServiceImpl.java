package za.ac.cput.service.impl;

import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepository;
import za.ac.cput.service.SupplierService;

import java.util.Set;
/*
Author: Ethan Botes - 220101299
This is the implementation for the service SupplierService
Date 11/06/2023
 */
public class SupplierServiceImpl implements SupplierService {

    private static SupplierServiceImpl service = null;

    private SupplierRepository repository = null;


    private SupplierServiceImpl(){
        if(repository == null){
            repository = SupplierRepository.getRepository();
        }
    }

    public static SupplierServiceImpl getService(){
        if(service == null){
            service = new SupplierServiceImpl();
        }
        return service;
    }

    @Override
    public Supplier create(Supplier supplier){return repository.create(supplier);}

    @Override
    public Supplier read(Supplier id){
        return repository.read(id.getSupplierID());
    }

    @Override
    public Supplier update(Supplier supplier){
        return repository.update(supplier);
    }

    @Override
    public boolean delete(Supplier id){
        return repository.delete(id.getSupplierID());
    }

    @Override
    public Set<Supplier> getAll(){
        return repository.getAll();
    }

}
