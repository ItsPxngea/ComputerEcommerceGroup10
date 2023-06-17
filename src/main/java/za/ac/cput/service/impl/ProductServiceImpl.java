package za.ac.cput.service.impl;
/* ProductServiceImpl.java
 This is the implementation for the service ProductServiceImpl.java
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import za.ac.cput.repository.impl.ProductRepositoryImpl;
import za.ac.cput.service.ProductService;

import java.util.Set;

public class ProductServiceImpl implements ProductService{
    private static ProductServiceImpl service = null;
    private ProductRepositoryImpl repository = null;

    private ProductServiceImpl(){
        if(repository == null){
            repository = ProductRepositoryImpl.getRepository();
        }
    }

    public static ProductServiceImpl getService(){
        if(service == null){
            service = new ProductServiceImpl();
        }
        return service;
    }

    @Override
    public za.ac.cput.domain.Product create(za.ac.cput.domain.Product product) {
        return repository.create(product);
    }

    @Override
    public za.ac.cput.domain.Product read(String id) {
        return repository.read(id);
    }

    @Override
    public za.ac.cput.domain.Product update(za.ac.cput.domain.Product product) {
        return repository.update(product);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }

    @Override
    public Set<za.ac.cput.domain.Product> getAll() {
        return repository.getAll();
    }
}
