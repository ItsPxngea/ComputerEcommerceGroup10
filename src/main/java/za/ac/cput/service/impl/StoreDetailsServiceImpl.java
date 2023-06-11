package za.ac.cput.service.impl;

import za.ac.cput.domain.StoreDetails;
import za.ac.cput.repository.StoreDetailsRepository;
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
    private StoreDetailsRepository repository = null;

    private StoreDetailsServiceImpl(){
        if (repository == null){
            repository = StoreDetailsRepository.getRepository();
        }
    }

    public static StoreDetailsServiceImpl getService(){
        if (service == null){
            service = new StoreDetailsServiceImpl();
        }
        return service;
    }

    @Override
    public StoreDetails create(StoreDetails storeDetails){
        return repository.create(storeDetails);
    }

    @Override
    public StoreDetails read(StoreDetails id){
        return repository.read(id.getStoreID());
    }

    @Override
    public StoreDetails update(StoreDetails storeDetails){
        return repository.update(storeDetails);
    }

    @Override
    public boolean delete(StoreDetails id){
        return repository.delete(id.getStoreID());
    }

    @Override
    public Set<StoreDetails> getAll(){
        return repository.getAll();
    }
}
