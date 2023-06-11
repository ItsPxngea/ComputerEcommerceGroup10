package za.ac.cput.repository;
/*
     Entity for the ProductRepository
     Author: Reece Bergstedt - 221075240
     Date: 22 March 2023
*/
import za.ac.cput.domain.Product;

import java.util.Set;

public interface iProductRepository {

    public Set<Product> getAll();

}
