package za.ac.cput.service.impl;
/* ProductServiceImpl.java
 This is the implementation for the service ProductServiceImpl.java
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.service.ProductService;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService{
    private static ProductServiceImpl service;
    @Override
    public za.ac.cput.domain.Product create(Product product) {
        return service.create(product);
    }

    @Override
    public za.ac.cput.domain.Product read(String id) {
        return service.read(id);
    }

    @Override
    public za.ac.cput.domain.Product update(Product product) {
        return service.update(product);
    }

    @Override
    public boolean delete(String id) {
        return service.delete(id);
    }

    @Override
    public Set<Product> getAll() {
        return service.getAll();
    }
}
