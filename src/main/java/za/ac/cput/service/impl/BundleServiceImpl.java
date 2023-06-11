package za.ac.cput.service.impl;
/* BundleServiceImpl.java
 This is the implementation for the service BundleServiceImpl.java
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import za.ac.cput.domain.Bundle;
import za.ac.cput.repository.BundleRepository;
import za.ac.cput.service.BundleService;

import java.util.Set;

public class BundleServiceImpl implements BundleService{
    private static BundleServiceImpl service = null;
    private BundleRepository repository = null;

    private BundleServiceImpl(){
        if(repository == null){
            repository = BundleRepository.getRepository();
        }
    }

    public static BundleServiceImpl getService(){
        if(service == null){
            service = new BundleServiceImpl();
        }
        return service;
    }

    @Override
    public Bundle create(Bundle bundle) {
        return repository.create(bundle);
    }

    @Override
    public Bundle read(Bundle id) {
        return repository.read(id.getBundleID());
    }

    @Override
    public Bundle update(Bundle bundle) {
        return repository.update(bundle);
    }

    @Override
    public boolean delete(Bundle id) {
        return repository.delete(id.getBundleID());
    }

    @Override
    public Set<Bundle> getAll() {
        return repository.getAll();
    }
}


