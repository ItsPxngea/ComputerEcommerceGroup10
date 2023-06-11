package za.ac.cput.service.impl;
/* ProductServiceImpl.java
 This is the implementation for the service ProductServiceImpl.java
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.service.ProductService;

import java.util.Set;

public class ProductServiceImpl implements ProductService{
    private static ProductServiceImpl service = null;
    private ProductRepository repository = null;

    private ProductServiceImpl(){
        if(repository == null){
            repository = ProductRepository.getRepository();
        }
    }

    public static ProductServiceImpl getService(){
        if(service == null){
            service = new ProductServiceImpl();
        }
        return service;
    }

    @Override
    public Product create(Product product) {
        return repository.create(product);
    }

    @Override
    public Product read(Product id) {
        return repository.read(id.getProductID());
    }

    @Override
    public Product update(Product product) {
        return repository.update(product);
    }

    @Override
    public boolean delete(Product id) {
        return repository.delete(id.getProductID());
    }

    @Override
    public Set<Product> getAll() {
        return repository.getAll();
    }
}
