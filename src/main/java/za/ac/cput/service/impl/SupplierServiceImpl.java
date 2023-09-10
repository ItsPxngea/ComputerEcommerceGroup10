package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepository;
import za.ac.cput.service.SupplierService;

import java.util.List;
import java.util.Set;
/*
Author: Ethan Botes - 220101299
This is the implementation for the service SupplierService
Date 11/06/2023
 */

@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository repository;
    
    @Autowired
    private SupplierServiceImpl(SupplierRepository repository){
        this.repository = repository;
    }

    @Override
    public Supplier create(Supplier supplierOrder){
        return this.repository.save(supplierOrder);
    }

    @Override
    public Supplier read(String id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Supplier update(Supplier supplierOrder){
        if(this.repository.existsById((supplierOrder.getSupplierID())))
            return this.repository.save(supplierOrder);
        return null;
    }

    @Override
    public boolean delete(String id){
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Supplier> getAll(){
        return repository.findAll();
    }

}
