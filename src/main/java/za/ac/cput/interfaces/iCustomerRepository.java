package za.ac.cput.interfaces;

/* iCustomerRepository.java
Interface for the Customer Repository
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface iCustomerRepository {
    public Set<Customer> getAll();
}
