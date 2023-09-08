package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplierAddress;
import za.ac.cput.factory.SupplierAddressFactory;
import za.ac.cput.repository.SupplierAddressRepository;
import za.ac.cput.service.SupplierAddressService;

import java.util.List;

@Service
public class SupplierAddressServiceImpl implements SupplierAddressService {
    private SupplierAddressRepository repository;

    @Autowired
    private SupplierAddressServiceImpl(SupplierAddressRepository repo){
        this.repository = repo;
    }

    @Override
    public SupplierAddress create(SupplierAddress supplierAddress){
        return this.repository.save(supplierAddress);
    }
    @Override
    public SupplierAddress read(String id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public SupplierAddress update(SupplierAddress supplierAddress){
        if(this.repository.existsById(supplierAddress.getSupplierAddressID())){
            return this.repository.save(supplierAddress);
        }
        return null;

    }

    @Override
    public boolean delete(String id){
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<SupplierAddress> getAll(){
        return this.repository.findAll();
    }

}
