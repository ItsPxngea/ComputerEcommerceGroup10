package za.ac.cput.repository.impl;
/* ProductRepository.java
     Entity for the ProductRepository
     Author: Reece Bergstedt - 221075240
     Date: 22 March 2023
*/

import java.util.HashSet;
import java.util.Set;
public class ProductRepositoryImpl implements za.ac.cput.repository.ProductRepository {

    private Set<za.ac.cput.domain.Product> productDB = null;
    private static ProductRepositoryImpl repository = null;
    private ProductRepositoryImpl(){
        productDB = new HashSet<za.ac.cput.domain.Product>();
    }

    public static ProductRepositoryImpl getRepository(){
        if(repository == null){
            repository = new ProductRepositoryImpl();
        }
        return repository;
    }

    public za.ac.cput.domain.Product create(za.ac.cput.domain.Product product) {
        boolean success = productDB.add(product);
        if(!success) {
            return null;
        }
        return product;
    }

    public za.ac.cput.domain.Product read(String productID) {
        za.ac.cput.domain.Product p = productDB.stream()
                .filter(e -> e.getProductID().equals(productID))
                .findAny()
                .orElse(null);
        return p;
    }

    public za.ac.cput.domain.Product update(za.ac.cput.domain.Product product) {
        za.ac.cput.domain.Product oldProduct= read(product.getProductID());
        if(oldProduct != null){
            productDB.remove(oldProduct);
            productDB.add(product);
            return product;
        }
        return null;
    }

    public boolean delete(String productID) {
        za.ac.cput.domain.Product productToDelete = read(productID);
        if(productToDelete == null){
            return false;
        }
        productDB.remove(productToDelete);
        return true;
    }

    @Override
    public Set<za.ac.cput.domain.Product> getAll() {
        return productDB;
    }
}
