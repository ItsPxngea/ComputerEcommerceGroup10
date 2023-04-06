package za.ac.cput.interfaces;
/* ProductRepository.java
     Entity for the ProductRepository
     Author: Reece Bergstedt - 221075240
     Date: 22 March 2023
*/
import za.ac.cput.domain.Bundle;
import za.ac.cput.domain.Product;
import java.util.*;
public class ProductRepository implements iProductRepository {

    private Set<Product> productDB = null;
    private static ProductRepository repository = null;
    private ProductRepository(){
        productDB = new HashSet<Product>();
    }

    public static ProductRepository getRepository(){
        if(repository == null){
            repository = new ProductRepository();
        }
        return repository;
    }

    public Product create(Product product) {
        boolean success = productDB.add(product);
        if(!success) {
            return null;
        }
        return product;
    }

    public Product read(String productID) {
        Product p = productDB.stream()
                .filter(e -> e.getProductID().equals(productID))
                .findAny()
                .orElse(null);
        return p;
    }

    public Product update(Product product) {
        Product oldProduct= read(product.getProductID());
        if(oldProduct != null){
            productDB.remove(oldProduct);
            productDB.add(product);
            return product;
        }
        return null;
    }

    public boolean delete(String productID) {
        Product productToDelete = read(productID);
        if(productToDelete == null){
            return false;
        }
        productDB.remove(productToDelete);
        return true;
    }

    @Override
    public Set<Product> getAll() {
        return productDB;
    }
}
