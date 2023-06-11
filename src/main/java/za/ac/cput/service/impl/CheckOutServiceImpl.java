package za.ac.cput.service.impl;
/*
CheckOutServiceImpl.java

Author: Michael Daniel Johnson, 221094040
Date: 11/06/2023
*/
import za.ac.cput.domain.CheckOut;
import za.ac.cput.repository.CheckOutRepository;
import za.ac.cput.service.CheckOutService;
import java.util.Set;

public class CheckOutServiceImpl implements CheckOutService{
    private static CheckOutServiceImpl service = null;
    private CheckOutRepository repository = null;

    private CheckOutServiceImpl(){
        if(repository == null){
            repository = CheckOutRepository.getRepo();
        }
    }

    public static CheckOutServiceImpl getService(){
        if(service == null){
            service = new CheckOutServiceImpl();
        }
        return service;

    }
    @Override
    public CheckOut create(CheckOut checkOut){
        return repository.create(checkOut);
    }

    @Override
    public CheckOut read (CheckOut id){
        return repository.read(id.getCheckOutID());
    }

    @Override
    public CheckOut update (CheckOut checkOut){
        return repository.update(checkOut);
    }

    @Override
    public boolean delete (CheckOut id){
        return repository.delete(id.getCheckOutID());
    }

    @Override
    public Set<CheckOut> getAll() {
        return repository.getAll();
    }

}
