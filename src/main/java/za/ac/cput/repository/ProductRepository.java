package za.ac.cput.repository;
/*
     Entity for the ProductRepository
     Author: Reece Bergstedt - 221075240
     Date: 22 March 2023
*/
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;

import java.util.Set;

@Repository
public interface ProductRepository {

    public Set<Product> getAll();

}
