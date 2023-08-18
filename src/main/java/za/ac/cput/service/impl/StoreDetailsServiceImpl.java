package za.ac.cput.service.impl;

import za.ac.cput.repository.impl.StoreDetailsRepositoryImpl;
import za.ac.cput.service.StoreDetailsService;

import java.util.Set;

/*
    StoreDetailsServiceImpl.java
    Author: Hanno Visser Immelman 221074414
    This is the implementation for the service StoreDetailsService.java
    Date: 10 - 06 - 2023
 */

public class StoreDetailsServiceImpl implements StoreDetailsService {
    private static StoreDetailsServiceImpl service = null;
    private StoreDetailsRepositoryImpl repository = null;

    private StoreDetailsServiceImpl(){
        if (repository == null){
            repository = StoreDetailsRepositoryImpl.getRepository();
        }
    }

    public static StoreDetailsServiceImpl getService(){
        if (service == null){
            service = new StoreDetailsServiceImpl();
        }
        return service;
    }

    @Override
    public za.ac.cput.domain.StoreDetails create(za.ac.cput.domain.StoreDetails storeDetails){
        return repository.create(storeDetails);
    }

    @Override
    public za.ac.cput.domain.StoreDetails read(String id){
        return repository.read(id);
    }

    @Override
    public za.ac.cput.domain.StoreDetails update(za.ac.cput.domain.StoreDetails storeDetails){
        return repository.update(storeDetails);
    }

    @Override
    public boolean delete(String id){
        return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.StoreDetails> getAll(){
        return repository.getAll();
    }
}
