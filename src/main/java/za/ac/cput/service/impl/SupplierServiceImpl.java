package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepository;
import za.ac.cput.service.SupplierService;
import java.util.List;

/*
Author: Ethan Botes - 220101299
This is the implementation for the service SupplierService
Date 11/06/2023
 */

@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository repository;

    @Autowired
    private SupplierServiceImpl(SupplierRepository repository){this.repository=repository;}

    @Override
    public Supplier create(Supplier supplier){return this.repository.save(supplier);}

    @Override
    public Supplier read(String supplierID){return this.repository.findById(supplierID).orElse(null);}

    @Override
    public Supplier update(Supplier supplier){
        if(this.repository.existsById((supplier.getSupplierID())))
            return this.repository.save(supplier);
        return null;
    }


    @Override
    public boolean delete(String supplierID){
        if(this.repository.existsById(supplierID)){
            this.repository.deleteById(supplierID);
            return true;
        }
        return false;
    }

    @Override
    public List<Supplier> getAll() {
        return this.repository.findAll();
    }

}
