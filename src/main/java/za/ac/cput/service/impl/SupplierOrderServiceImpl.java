package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplierOrder;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.SupplierOrderRepository;
import za.ac.cput.service.SupplierOrderService;

import java.util.List;
import java.util.Set;

/*
Author: Ethan Botes - 220101299
This is the implementation for the service SupplierOrderService
Date 11/06/2023
 */

@Service
public class SupplierOrderServiceImpl implements SupplierOrderService {

    private SupplierOrderRepository repository;

    @Autowired
    private SupplierOrderServiceImpl(SupplierOrderRepository repository){
        this.repository = repository;
    }

    @Override
    public SupplierOrder create(SupplierOrder supplierOrder){
        return this.repository.save(supplierOrder);
    }

    @Override
    public SupplierOrder read(String id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public SupplierOrder update(SupplierOrder supplierOrder){
        if(this.repository.existsById((supplierOrder.getOrderID())))
            return this.repository.save(supplierOrder);
        return null;
    }

    @Override
    public boolean delete(String orderID){
        if(this.repository.existsById(orderID)){
            this.repository.deleteById(orderID);
            return true;
        }
        return false;
    }

    @Override
    public List<SupplierOrder> getAll(){
        return repository.findAll();
    }
}
