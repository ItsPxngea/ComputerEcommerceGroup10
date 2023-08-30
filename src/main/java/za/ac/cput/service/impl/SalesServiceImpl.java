package za.ac.cput.service.impl;

/* SalesServiceImpl.java
Service implementation for the Sales
Author: David Henriques Garrancho (221475982)
Date: 16 August 2023
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Sales;
import za.ac.cput.repository.SalesRepository;
import za.ac.cput.service.SalesService;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    private SalesRepository repository;

    @Autowired
    private SalesServiceImpl(SalesRepository repository){
        this.repository = repository;
    }

    @Override
    public Sales create(Sales sales) {
        return this.repository.save(sales);
    }

    @Override
    public Sales read(String salesID) {
        return this.repository.findById(salesID).orElse(null);
    }

    @Override
    public Sales update(Sales sales) {
        if(this.repository.existsById((sales.getSaleID())))
            return this.repository.save(sales);
        return null;
    }

    @Override
    public boolean delete(String salesID) {
        if(this.repository.existsById(salesID)){
            this.repository.deleteById(salesID);
            return true;
        }
        return false;
    }

    @Override
    public List<Sales> getAll() {
        return this.repository.findAll();
    }
}
