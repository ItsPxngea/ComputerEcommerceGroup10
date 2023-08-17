package za.ac.cput.service.impl;
/* BundleServiceImpl.java
 This is the implementation for the service BundleServiceImpl.java
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import za.ac.cput.repository.impl.BundleRepositoryImpl;
import za.ac.cput.service.BundleService;

import java.util.Set;

public class BundleServiceImpl implements BundleService{
    private static BundleServiceImpl service = null;
    private BundleRepositoryImpl repository = null;

    private BundleServiceImpl(){
        if(repository == null){
            repository = BundleRepositoryImpl.getRepository();
        }
    }

    public static BundleServiceImpl getService(){
        if(service == null){
            service = new BundleServiceImpl();
        }
        return service;
    }

    @Override
    public za.ac.cput.domain.Bundle create(za.ac.cput.domain.Bundle bundle) {
        return repository.create(bundle);
    }

    @Override
    public za.ac.cput.domain.Bundle read(String id) {
        return repository.read(id);
    }

    @Override
    public za.ac.cput.domain.Bundle update(za.ac.cput.domain.Bundle bundle) {
        return repository.update(bundle);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.Bundle> getAll() {
        return repository.getAll();
    }
}


