package za.ac.cput.service.impl;

import za.ac.cput.domain.SupplierOrder;
import za.ac.cput.repository.SupplierOrderRepository;
import za.ac.cput.service.SupplierOrderService;

import java.util.Set;

/*
Author: Ethan Botes - 220101299
This is the implementation for the service SupplierOrderService
Date 11/06/2023
 */
public class SupplierOrderServiceImpl implements SupplierOrderService {

    private static SupplierOrderServiceImpl service = null;
    private SupplierOrderRepository repository = null;
    private SupplierOrderServiceImpl(){
        if(repository == null){
            repository = SupplierOrderRepository.getRepository();
        }
    }


    public static SupplierOrderServiceImpl getService(){
        if(service == null){
            service = new SupplierOrderServiceImpl();
        }
        return service;
    }

    @Override
    public SupplierOrder create(SupplierOrder supplierOrder){
        return repository.create(supplierOrder);
    }

    @Override
    public SupplierOrder read(SupplierOrder orderID){
        return repository.read(orderID.getOrderID());
    }

    @Override
    public  SupplierOrder update(SupplierOrder supplierOrder){
        return repository.update(supplierOrder);
    }

    @Override
    public boolean delete(SupplierOrder orderID){
        return repository.delete(orderID.getOrderID());
    }

    @Override
    public Set<SupplierOrder> getAll(){
        return repository.getAll();
    }
}
