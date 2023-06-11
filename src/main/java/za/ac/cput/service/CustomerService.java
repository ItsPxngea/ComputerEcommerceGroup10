package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.util.Set;

/*
    CustomerService.java
    Author: David Henriques Garrancho
    This is the Service for the service the Customer entity
    Date: 09 - 06 - 2023
 */

public interface CustomerService extends IService<Customer, String>{

    Set<Customer> getAll();
}
