package za.ac.cput.service.impl;
/*
CheckOutServiceImpl.java

Author: Michael Daniel Johnson, 221094040
Date: 11/06/2023
*/

import za.ac.cput.repository.impl.CheckOutRepositoryImpl;
import za.ac.cput.service.CheckOutService;

import java.util.Set;

public class CheckOutServiceImpl implements CheckOutService{
    private static CheckOutServiceImpl service = null;
    private CheckOutRepositoryImpl repository = null;

    private CheckOutServiceImpl(){
        if(repository == null){
            repository = CheckOutRepositoryImpl.getRepo();
        }
    }

    public static CheckOutServiceImpl getService(){
        if(service == null){
            service = new CheckOutServiceImpl();
        }
        return service;

    }
    @Override
    public za.ac.cput.domain.CheckOut create(za.ac.cput.domain.CheckOut checkOut){
        return repository.create(checkOut);
    }

    @Override
    public za.ac.cput.domain.CheckOut read (String id){
        return repository.read(id);
    }

    @Override
    public za.ac.cput.domain.CheckOut update (za.ac.cput.domain.CheckOut checkOut){
        return repository.update(checkOut);
    }

    @Override
    public boolean delete (String id){
        return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.CheckOut> getAll() {
        return repository.getAll();
    }

}
