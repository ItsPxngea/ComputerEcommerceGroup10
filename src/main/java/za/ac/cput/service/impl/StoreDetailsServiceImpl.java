package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.repository.SalesRepository;
import za.ac.cput.repository.StoreDetailsRepository;
import za.ac.cput.service.StoreDetailsService;

import java.util.List;
import java.util.Set;

/*
    StoreDetailsServiceImpl.java
    Author: Hanno Visser Immelman 221074414
    This is the implementation for the service StoreDetailsService.java
    Date: 10 - 06 - 2023
 */

@Service
public class StoreDetailsServiceImpl implements StoreDetailsService {
    private StoreDetailsRepository repository;

    @Autowired
    private StoreDetailsServiceImpl(StoreDetailsRepository repository){
        this.repository = repository;
    }

    @Override
    public StoreDetails create(StoreDetails storeDetails) {
        return this.repository.save(storeDetails);
    }

    @Override
    public StoreDetails read(String salesID) {
        return this.repository.findById(salesID).orElse(null);
    }

    @Override
    public StoreDetails update(StoreDetails storeDetails) {
        if(this.repository.existsById((storeDetails.getStoreID())))
            return this.repository.save(storeDetails);
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
    public List<StoreDetails> getAll() {
        return this.repository.findAll();
    }
}
