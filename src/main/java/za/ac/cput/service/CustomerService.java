package za.ac.cput.service;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;

import java.util.List;

/*
    CustomerService.java
    Author: David Henriques Garrancho
    This is the Service for the service the Customer entity
    Date: 09 - 06 - 2023
 */

public interface CustomerService extends IService<Customer, String> {
    List<Customer> getAll();
}
