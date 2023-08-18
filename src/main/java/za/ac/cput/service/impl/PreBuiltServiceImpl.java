package za.ac.cput.service.impl;
/*
CheckOutServiceImpl.java

Author: Michael Daniel Johnson, 221094040
Date: 11/06/2023
*/

import za.ac.cput.repository.impl.PreBuiltRepositoryImpl;
import za.ac.cput.service.PreBuiltService;

import java.util.Set;
public class PreBuiltServiceImpl implements PreBuiltService {

    private static PreBuiltServiceImpl service = null;
    private PreBuiltRepositoryImpl repository = null;

    private PreBuiltServiceImpl(){
        if (repository == null){
            repository = PreBuiltRepositoryImpl.getRepo();
        }
    }

    public static PreBuiltServiceImpl getService(){
        if(service == null){
            service = new PreBuiltServiceImpl();
        }
        return service;
    }

    @Override
    public za.ac.cput.domain.PreBuilt create(za.ac.cput.domain.PreBuilt preBuilt){
        return repository.create(preBuilt);
    }

    @Override
    public za.ac.cput.domain.PreBuilt read (String id){
        return repository.read(id);
    }

    @Override
    public za.ac.cput.domain.PreBuilt update (za.ac.cput.domain.PreBuilt preBuilt){
        return repository.update(preBuilt);
    }

    @Override
    public boolean delete (String id){
        return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.PreBuilt> getAll() {
        return repository.getAll();
    }

}
