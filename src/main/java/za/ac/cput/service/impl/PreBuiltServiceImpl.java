package za.ac.cput.service.impl;
/*
CheckOutServiceImpl.java

Author: Michael Daniel Johnson, 221094040
Date: 11/06/2023
*/
import za.ac.cput.domain.CheckOut;
import za.ac.cput.domain.PreBuilt;
import za.ac.cput.repository.PreBuiltRepository;
import za.ac.cput.service.PreBuiltService;
import java.util.Set;
public class PreBuiltServiceImpl implements PreBuiltService {

    private static PreBuiltServiceImpl service = null;
    private PreBuiltRepository repository = null;

    private PreBuiltServiceImpl(){
        if (repository == null){
            repository = PreBuiltRepository.getRepo();
        }
    }

    public static PreBuiltServiceImpl getService(){
        if(service == null){
            service = new PreBuiltServiceImpl();
        }
        return service;
    }

    @Override
    public PreBuilt create(PreBuilt preBuilt){
        return repository.create(preBuilt);
    }

    @Override
    public PreBuilt read (PreBuilt id){
        return repository.read(id.getBuildID());
    }

    @Override
    public PreBuilt update (PreBuilt preBuilt){
        return repository.update(preBuilt);
    }

    @Override
    public boolean delete (PreBuilt id){
        return repository.delete(id.getBuildID());
    }

    @Override
    public Set<PreBuilt> getAll() {
        return repository.getAll();
    }

}
