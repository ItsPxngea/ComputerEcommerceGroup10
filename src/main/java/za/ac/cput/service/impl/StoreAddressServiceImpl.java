package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.StoreAddress;
import za.ac.cput.repository.StoreAddressRepository;
import za.ac.cput.service.StoreAddressService;
import java.util.List;


@Service
public class StoreAddressServiceImpl implements StoreAddressService {

    private StoreAddressRepository repository;

    @Autowired
    private StoreAddressServiceImpl(StoreAddressRepository repository) {
        this.repository = repository;
    }
    @Override
    public StoreAddress create(StoreAddress storeAddress) {
        return this.repository.save(storeAddress);
    }

    @Override
    public StoreAddress read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public StoreAddress update(StoreAddress storeAddress) {
        if(this.repository.existsById(storeAddress.getStoreAddressID()))
            return this.repository.save(storeAddress);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
            return false;
    }

    @Override
    public List<StoreAddress> getAll() {
        return this.repository.findAll();
    }
}
