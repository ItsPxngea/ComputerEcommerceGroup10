package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.service.StoreDetailsService;

import java.util.Set;

/*
    StoreDetailsServiceImpl.java
    Author: Hanno Visser Immelman 221074414
    This is the implementation for the service StoreDetailsService.java
    Date: 10 - 06 - 2023
 */

@Service
public class StoreDetailsServiceImpl implements StoreDetailsService {
    private static StoreDetailsServiceImpl service;

    @Override
    public StoreDetails create(StoreDetails storeDetails){
        return service.create(storeDetails);
    }

    @Override
    public StoreDetails read(String id){
        return service.read(id);
    }

    @Override
    public StoreDetails update(StoreDetails storeDetails){
        return service.update(storeDetails);
    }

    @Override
    public boolean delete(String id){
        return service.delete(id);
    }

    @Override
    public Set<StoreDetails> getAll(){
        return service.getAll();
    }
}
