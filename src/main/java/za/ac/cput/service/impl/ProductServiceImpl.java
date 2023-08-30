package za.ac.cput.service.impl;
/* ProductServiceImpl.java
 This is the implementation for the service ProductServiceImpl.java
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.service.ProductService;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository repository;

    @Autowired
    private ProductServiceImpl(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Product read(String salesID) {
        return this.repository.findById(salesID).orElse(null);
    }

    @Override
    public Product update(Product product) {
        if(this.repository.existsById((product.getProductID())))
            return this.repository.save(product);
        return null;
    }

    @Override
    public boolean delete(String salesID) {
        if(this.repository.existsById(salesID)){
            this.repository.deleteById(salesID);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }
}
